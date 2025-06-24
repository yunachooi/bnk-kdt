package com.example.sseBuzz.sse;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
public class SseEmitters {
    private final Map<Long, SseEmitter> emitters = new ConcurrentHashMap<>();

    public void add(Long userId, SseEmitter emitter) {
        emitters.put(userId, emitter);
    }

    public void remove(Long userId) {
        emitters.remove(userId);
    }

    public void sendTo(Long userId, String data) {
        SseEmitter emitter = emitters.get(userId);
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event().name("post-alert").data(data));
                System.out.println("[알림 전송 성공] userId=" + userId + ", data=" + data);
            } catch (Exception e) {
                System.err.println("[알림 전송 실패] userId=" + userId + ", 에러: " + e.getMessage());
                emitters.remove(userId);
            }
        } else {
            System.out.println("[알림 전송 실패] userId=" + userId + " 에 대한 SSEEmitter 없음");
        }
    }

    public Map<Long, SseEmitter> getEmitters() {
        return emitters;
    }
}
