package com.example.demo3.service;

import com.example.demo3.entity.User;
import jakarta.persistence.*;

import javax.swing.text.Style;
import java.lang.reflect.Type;
import java.util.List;

public class UserService {
    private EntityManagerFactory emf;

    private EntityManager em;

    public UserService(){
        emf = Persistence.createEntityManagerFactory("myPU");
        em = emf.createEntityManager();
    }

    //CREATE - 새로운 자료 저장
    public void createUser(String username, String email, Integer age){
        EntityTransaction tx = em.getTransaction();
        try{
            //플러쉬(Flush): 엔티티(영속성 데이터)와 데이터베이스의 동기화(영구 반영)
            tx.begin(); //트랜잭션 시작
            User user = new User(username, email, age);
            em.persist(user); //엔티티를 영속 상태로 만들어 줌.
            tx.commit(); //트랜잭션 종료: 합쳐지는 시점.

            System.out.println("사용자 생성 성공: " + user);
        } catch (Exception e){
            tx.rollback(); //트랜잭션 실패
            System.err.println("사용자 생성 실패: " + e.getMessage());
        }
    }

    //READ - 사용자 조회(PK 사용)
    public User findUserById(Long id){
        try{
            User user  = em.find(User.class, id);

            if(user != null){
                System.out.println("Success find user: " + user);
            } else {
                System.out.println("ID " + id + " is not exist!");
            }
            return user;
        } catch(Exception e) {
            System.out.println("Fail find user: " + e.getMessage());
            return null;
        }
    }

    //READ - 모든 사용자 조회
    public List<User> findAllUsers(){
        try{
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
            List<User> users = query.getResultList();
            System.out.println("All Users Count : " + users.size());
            return users;
        } catch (Exception e){
            System.out.println("fail..." + e.getMessage());
            return null;
        }
    }

    //UPDATE - 사용자 정보 수정
    public void updateUser(Long id, String newEmail){
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            User user = em.find(User.class, id);
            if(user != null){
                user.setEmail(newEmail);
                tx.commit();
                System.out.println("Success: " + user);
            } else {
                tx.rollback();
                System.out.println("None!");
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    //READ - 특정 조건으로 사용자 조회
    public List<User> findUserByAge(Integer minAge){
        try{
            TypedQuery<User> query = em.createQuery(
                    "SELECT u FROM User u WHERE u.age >= :minAge", User.class
            );
            query.setParameter("minAge", minAge);

            List<User> users = query.getResultList();
            System.out.println(minAge + "세 이상의 사용자 수 : " + users.size());

            return users;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //DELETE - 사용자 삭제
    public void deleteUser(Long id){
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            User user = em.find(User.class, id);
            if(user != null){
                em.remove(user);
                tx.commit();
                System.out.println("사용자 삭제 완료 : " + user);
            } else {
                tx.rollback();
                System.out.println("삭제할 사용자를 찾을 수 없습니다.");
            }
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    //UPDATE - 준영속 엔티티 병합
    public void mergeUser(){
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            /*
            User user = new User("test-user", "test@green.com", 100);
            em.persist(user); //==save()
            */
            User user = em.find(User.class, 1l);
            System.out.println(1 + ") " + em.contains(user)); //true
            em.clear();

            System.out.println(2 + ") " + em.contains(user)); //false
            User managedUser = em.merge(user);
            System.out.println(3 + ") " + em.contains(managedUser)); //true

            tx.commit();
            System.out.println("Marged..." + managedUser);
            em.detach(managedUser);

            System.out.println(4 + ") " + em.contains(managedUser)); //false
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
}
