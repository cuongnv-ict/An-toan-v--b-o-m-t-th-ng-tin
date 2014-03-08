/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author nguyen van cuong
 */
public class DataTable {
    private Connection connect;
    ResultSet rs1,rs2;
    Statement statement;
    TableModel model;
    Object [][] rowColumn;
    public DataTable(){
        ConnectData c = new ConnectData();
        connect = c.connectionDatabase();
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DataTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void BangDanhSachLop(JTable table){
        try {
            Object [] nameColumn = { "Ten Lop", "Trinh Do", "Hoc Ky","Giao Vien", "Ngay Bat Dau", "Ngay Ket Thuc", "So Hoc Sinh hien tai", "So Hoc Sinh toi da", "Trang Thai", "Đánh Dấu"};
            ArrayList<Object []> data = new ArrayList<Object []>();
            rs1 = statement.executeQuery("select * ,count(Students_id) from classes,classes_has_students where classes.id= Classes_Id group by Classes_Id");
            while(rs1.next()){
                Object str[] = new Object[10];
                    str[0] = rs1.getString(6);
                   switch(rs1.getInt(4)){
                       case 1:
                           str[1] = "NẮNG MAI (SUNSHINE)";
                           break;
                       case 2:
                            str[1] = "TỔ ONG (BEEHIVE)";
                           break;
                       case 3:
                            str[1] = "TỔ KÉN (CHRYSALIS)";
                           break;
                       case 4:
                            str[1] = "MẪU GIÁO (KINDERGARTEN)";
                           break;
                   }
                   str[2] = rs1.getString(3);
                   str[3] = rs1.getString(7);
                   str[4] = rs1.getString(8);
                   str[5] = rs1.getString(9);
                   str[6] = rs1.getString(17);
                   str[7] = rs1.getString(11);
                   switch(rs1.getInt(12)){
                       case 0:
                           str[8] = "Đang giảng dạy";
                           break;
                       case 1:
                            str[8] = "Đã kết thúc";
                           break;
                 }       
                 str[9]= false;
                 data.add(str);
            }
            Object [][] rowColumn = new Object[data.size()][];
            for (int i = 0; i < data.size(); i++) {
            rowColumn[i] = data.get(i);
            model = new DefaultTableModel(rowColumn, nameColumn){
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
            };
            table.setModel(model);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DataTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void BangDanhSachHocSinh(JTable table){
        try {
            Object [] nameColumn = {  "ID", "Tên", "Ngay Sinh","Trình Độ", "Lớp", "Hình Thức Học" };
            ArrayList<String []> data = new ArrayList<String []>();
            rs1 = statement.executeQuery("select students.id,fullname,brithday,levels_id,nameclass,isclient  from students,classes,classes_has_students where students.id = students_id and classes.id=classes_id");
            while(rs1.next()){
                String str[] = new String[6];
                    str[0] = rs1.getString(1);
                    str[1] = rs1.getString(2);
                    str[2] = rs1.getString(3);
                   switch(rs1.getInt(4)){
                       case 1:
                           str[3] = "NẮNG MAI (SUNSHINE)";
                           break;
                       case 2:
                            str[3] = "TỔ ONG (BEEHIVE)";
                           break;
                       case 3:
                            str[3] = "TỔ KÉN (CHRYSALIS)";
                           break;
                       case 4:
                            str[3] = "MẪU GIÁO (KINDERGARTEN)";
                           break;
                   }
                   
                 
                   str[4] = rs1.getString(5);
                   switch(rs1.getInt(6)){
                       case 1:
                           str[5] = "Chinh quy";
                           break;
                       case 0:
                            str[5] = "Chuong trinh ban la khach";
                           break;
                 }       
                 data.add(str);
            }
            Object [][] rowColumn = new Object[data.size()][];
            for (int i = 0; i < data.size(); i++) {
            rowColumn[i] = data.get(i);
            model = new DefaultTableModel(rowColumn, nameColumn){
            };
            table.setModel(model);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DataTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void BangDanhSachPhi(JTable table){
        try {
            Object [] nameColumn = {  "Tên", "Kì học", "Năm học", "Giá" };
            ArrayList<Object []> data = new ArrayList<Object []>();
            rs1 = statement.executeQuery("select * from cost");
            while(rs1.next()){
                if(rs1.getInt(5)!=0) continue;
                String str[] = new String[4];
                str[0] = rs1.getString(4);
                str[1] = rs1.getString(3);
                str[2] = rs1.getString(7);
                str[3] = rs1.getString(6);        
                if(str[3].charAt(0)=='-'){
                    str[3] = str[3].substring(1);
                }
                data.add(str);
            }
            Object [][] rowColumn = new Object[data.size()][];
            for (int i = 0; i < data.size(); i++) {
            rowColumn[i] = data.get(i);
            model = new DefaultTableModel(rowColumn, nameColumn){
            };
            table.setModel(model);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DataTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void BangDanhHSLop(int classes_id,JTable table){
        try {
            Object [] nameColumn = {"Mã Số HS", "Họ Tên", "Ngày Sinh", "Hình Thức Học", "SĐT", "Người Đại Diện", "Đánh Dấu"};
            ArrayList<Object []> data = new ArrayList<Object []>();
            rs1 = statement.executeQuery("select * from students where students.id in(select students_id from classes_has_students where classes_id = "+classes_id+ " )");
            while(rs1.next()){
                Object[]str = new Object[7];
                str[0] = rs1.getString(1);
                str[1] = rs1.getString(3);
                str[2] = rs1.getString(4);
                switch(rs1.getInt(7)){
                       case 1:
                           str[3] = "Chinh quy";
                           break;
                       case 0:
                            str[3] = "Chuong trinh ban la khach";
                           break;
                 }       
                str[4] = rs1.getString(5); 
                str[5] = rs1.getString(6);
                str[6] = false;
                data.add(str);
            }
            Object [][] rowColumn = new Object[data.size()][];
            for (int i = 0; i < data.size(); i++) {
            rowColumn[i] = data.get(i);
            model = new DefaultTableModel(rowColumn, nameColumn){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            };
            table.setModel(model);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DataTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void BangDanhSachHocSinhDuCho(JTable table){
        
    }
    public void BangDanhSachHSDongDuPhi(int students_id,JTable table){
         try {
            Object [] nameColumn = {"Mã Số HS", "Họ Tên", "Ngày Sinh", "Hình Thức Học", "SĐT", "Người Đại Diện", "Đánh Dấu"};
            ArrayList<Object []> data = new ArrayList<Object []>();
            rs1 = statement.executeQuery("select * from students where students.id in(select students_id from students_has_cost where isdebt = 0 group by students_id)");
            while(rs1.next()){
                Object[]str = new Object[7];
                str[0] = rs1.getString(1);
                str[1] = rs1.getString(3);
                str[2] = rs1.getString(4);
                switch(rs1.getInt(7)){
                       case 1:
                           str[3] = "Chinh quy";
                           break;
                       case 0:
                            str[3] = "Chuong trinh ban la khach";
                           break;
                 }       
                str[4] = rs1.getString(5); 
                str[5] = rs1.getString(6);
                str[6] = false;
                data.add(str);
            }
            Object [][] rowColumn = new Object[data.size()][];
            for (int i = 0; i < data.size(); i++) {
            rowColumn[i] = data.get(i);
            model = new DefaultTableModel(rowColumn, nameColumn){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            };
            table.setModel(model);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DataTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void BangDanhSachHocSinhNoPhi(int students_id,JTable table){
        
    }
    public void BangHocPhiCuaHocSinh(int students_id,JTable table){
        
    }
    public void BangLichSuDongTienCuaHocSinh(int students_id,JTable table){
        
    }
    public void BangThemHocPhiChoHocSinh(JTable table,int Student_ID){
        
    }
}
