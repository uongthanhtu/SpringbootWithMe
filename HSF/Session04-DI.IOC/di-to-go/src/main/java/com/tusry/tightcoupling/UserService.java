package com.tusry.tightcoupling;

public class UserService {
    //Lo nhiệm vụ liên quan đến user entity class, thông tin người dùng của app
    //Bao gồm: thêm, xóa (xóa mềm, set trạng thái bằng false/true, không làm lệnh xóa thật)
    //              sửa, tìm kiếm
    //              CRUD sẽ nhờ thằng REPO nó lo

    // Tuy nhiên phần thêm user add() còn cần thêm việc xử lý:
    // Gửi mail hoặc gửi tin nhắn đến hộp mail của người đăng kí hoặc SIM của user
    // Không dính đến database

    // Gửi mail và gửi sms không dính tới UserRepo class
    // mà là những công việc xử lý khác, vào hộp mail, tạo mail, vào tổng đài send sms số phone đăng kí
    // hàm gửi sms, mail để ở đâu???
    // có trong 5 nguyên lý nâng cao của oop: solid
    // S VÀ O
    // S (SRP): SINGLE RESPONSIBILITY PRINCIPLE: ĐƠN TRÁCH NHIỆM TRONG VIỆC THIẾT KẾ, 1 CLASS CHỈ NÊN TẬP TRUNG VÀO VIỆC NÓ MẠNH NHẤT,1 CLASS KHÔNG ÔM ĐÔỒM CÁC CÔNG VIỆC CỦA NHIỀU LĨNH VỰC KHÁC NHAU
    // 1 CLASS NẾU CẦN THAY ĐỔI, CHỈ NÊN CÓ 1 LÝ DO - CHỈ NÊN CÓ 1 THAY ĐỔI Ở 1 THỨ NÀO ĐÓ
    //                                                  KHÔNG CÓ NHIỀU CHỖ ĐỂ CÓ THỂ CẦN THAY ĐỔI
    // thay dổi
    // tách gửi mail và sms ra 2 class riêng mỗi thằng này giỏi công việc của mình - nguyên lý SRP

    // GUI ---- CONTROLLER ---- REPO ----- INFRA (EM, EMF) --------TABLE THẬT

    // cần khai báo 1 object lo việc chuyên gửi mail
    // class service phụ thuộc vào class MailSender trong vụ gửi mail
    // class MailSender gọi là dependency của class UserService
    // class A cần class B làm giúp việc gì mà B giỏi (SRP), thì B gọi la Dependency của A
    //làm xài B trong A
    // 1.khái báo B trong A, B objB
    // 2.new B()             B objB = new B();
    // ta đang full quyền control object B, object dependency

    private MailSender mailSender = new MailSender(); // mailSender là dependency của UserService
    // chủ động new để có object mà xài
    // chủ động khai báo dependency, chủ động new để dùng, gọi là : TIGHT COUPLING, DIRECT CONTROL ngĩa là UserService phụ thuộc chặt chẽ vào MailSender, chủ dộng tạo object (direct control)- ngược với IoC - Inversion of Control

    // lẽ ra hàm phải có thông tin info đưa vào mà đang giả lập nên không cần
    // email của người đăng kí
    public void registerAccount(String email) {
        // mình làm những việc gì đó: kiểm tra email trùng trong table
        // chèn xuống table .... qua UserRepository

        // việc quan trong, gửi mail
        System.out.println("Send mail to in service" + email);
        mailSender.sendNoti();
    }

}
