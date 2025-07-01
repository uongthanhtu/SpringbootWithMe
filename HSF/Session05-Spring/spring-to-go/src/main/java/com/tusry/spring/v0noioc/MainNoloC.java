package com.tusry.spring.v0noioc;

public class MainNoloC {
    public static void main(String[] args) {
        // không chơi IOC, InversionofControl, nghĩa là bạn phải tự lo tạo ra các object DEPENDENCY TRONG CODE CỦA MÌNH

        // TA MUỐN IN CÂU CHÀO TA PHẢI TỰ NEW OBJECT HelloMessage()
        HelloMessage helloMessage = new HelloMessage();
        helloMessage.sayHello("Hello no IoC, We create object manually!!");
        //Code truyền thống, tự new trong chỗ nào đó
    }


}
