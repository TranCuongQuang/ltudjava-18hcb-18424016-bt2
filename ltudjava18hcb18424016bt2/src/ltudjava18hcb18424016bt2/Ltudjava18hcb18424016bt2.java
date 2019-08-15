/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava18hcb18424016bt2;

/**
 *
 * @author quang
 */
public class Ltudjava18hcb18424016bt2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Thêm sinh viên
//        Student st = new Student();
//        st.setStudentCode("0312171");
//        st.setFullName("Tạ Tấn Thêm");
//        st.setGender(true);
//        st.setCardNumber("04568966");
//        boolean kq = StudentDAO.SaveStudent(st);
//        if (kq == true) {
//            System.out.println("Thêm thành công");
//        } else {
//            System.out.println("Thêm thất bại");
//        }
//
//        // Lấy danh sách sinh viên
//        List<Student> ds = StudentDAO.GetStudentList();
//        for (int i = 0; i < ds.size(); i++) {
//            Student sv = ds.get(i);
//            System.out.println("MSSV: " + sv.getStudentCode());
//            System.out.println("Họ và tên: " + sv.getFullName());
//        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Login lg = new Login();
            }
        });
    }
}
