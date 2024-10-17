package com.ohgiraffers.section02.sessionlistener;


import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {

    /*
     *  2. session (세션에서 발생 가능한 이벤트)
     *       2-1 : HttpSessionListener : HTTP 세션의 시작 및 종료에 대한 이벤트 리스너
     *       - 세션이 생성될 때 호출되며, 세션을 초기화하는 작업을 수행할 수 있다..
     *       - 세션이 종료될 때 호출되며, 세션 관련 자원을 정리한다..
     *
     *       2-2 : HttpSessionAttributeListener : HttpSession 에 속성을 추가, 제거, 수정하는 것에 대한 이벤트 리스너
     * */

    public SessionListenerTest() {
        System.out.println("session listener 인스턴스 생성");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // 세션이 생성될 때 동작한다.
        System.out.println("session created");
        System.out.println("생성된 session id : " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 세션이 만료될 때 동작한다.
        System.out.println("session destroyed");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // session 에 attribute 가 추가될 때 동작한다..
        System.out.println("session attribute added");
        System.out.println("세션에 추가된 attr : " + event.getName() + " : " + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("session attribute removed!!");
        System.out.println("세션에서 제거된 attr : " + event.getName() + " , " + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("session attribute replaced!!!");
        System.out.println("세션에 수정된 attr : " + event.getName() + " , " + event.getValue());
    }
}
