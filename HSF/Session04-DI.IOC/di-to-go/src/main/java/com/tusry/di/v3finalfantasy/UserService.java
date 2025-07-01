package com.tusry.di.v3finalfantasy;

public class UserService {

    //THAY VÌ PHỤ THUỘC VÀO THẰNG CỤ THỂ, TA PHỤ THUỘC VÀO THỨU CHUNG CHUNG GIÚP TA DỄ DÀNG CHƠI ĐA DẠNG MÓN MÀ KHÔNG CẦN SỬA CODE

    //PHỤ THUỘC INTERFACE LÀ ỨNG VỚI NGUYÊN LÝ
    // O: OPEN TO EXTENSION,        CLOSE TO MODIFICATION
    // CỨ THÊM SMS THOẢI MÁI        MÀ KHÔNG CẦN SỬA USERSERVICE

//    private SmsSender smsSender;
//    private EmailSender emailSender;
    //tight coupling
    // mai mốt thêm FireBase, đè class UserService ra sửa

    private NotiService notiService;// bạn muốn SMS, Email, FireBase,... thoải mái không sửa code nữa

    // đưa bên ngoài vào ,DI
    public UserService(NotiService notiService) {
        this.notiService = notiService;
    }

    public void registerUser(){
        notiService.sendNoti();// tính đa hình, hoặc sms, hoặc email, hoặc firebase!!
                                // gọi 1 chạy ra nhiều hướng đa hình dạng
    }

}
