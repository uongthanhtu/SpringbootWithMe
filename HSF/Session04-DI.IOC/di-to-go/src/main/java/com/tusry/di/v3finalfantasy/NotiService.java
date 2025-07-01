package com.tusry.di.v3finalfantasy;

public interface NotiService {
    // Là những class cha, clb, chỉ chứa hàm không code (sau này có hàm có code) là hàm ABSTRACT. CLB chỉ nói về luật chơi của CLB
    // Anh em tham gia CLB (Các class implement) thì thực thi luật chơi
    // CLB Đua xe, nhiệm vụ của anh em là implement mọi hình thức đua

    public void sendNoti();
    // để thằng sms lo code theo kiểu gửi tin nhắn
    // để email lo code theo kiểu gửi email
    // thằng class nào lo vụ viết code cho hàm này, gọi là IMPLEMENT, CONCRETE CLASS
    //INTERFACE SINH RA ĐỂ THỐNG NHẤT CÁCH ĐẶT TÊN HÀM CHO 1 NHÓM CLASS
    // CHỈ CẦN ĐẶT TÊN HÀ, ANH EM HƯỞNG ỨNG -> TÍNH ĐA HÌNH POLYMORPHISM
    // ĐỌC CUỐN SÁCH DESIGN PATTENS CỦA GoF Gang of Four

}
