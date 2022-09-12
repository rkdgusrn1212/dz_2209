package controller.book;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import isbn.ISBN;
import model.vo.Book;

public class BookTableModel extends AbstractTableModel {


    private ArrayList<Book> bookList = new ArrayList<>();//오로지 제목, 저자, 카테고리, 대여여부만 가진다.

    public void update(ArrayList<Book> book) {
        bookList = (ArrayList<Book>) book.clone();//이후 book의 수정에 독립적. 
    }

    public Book getBook(int idx) {
        if(idx<getRowCount()) {
            return bookList.get(idx);
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return bookList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = bookList.get(rowIndex);
        switch(columnIndex) {
        case 0:
            return book.getBname();
        case 1:
            return book.getWriter();
        case 2:
            return ISBN.convertCategory(book.getCategory());
        case 3:
            return book.getRegisterId()==null?"대여가능":"대여중";
        }
        return null;
    }



    @Override
    public String getColumnName(int column) {
        switch(column) {
        case 0:
            return "제 목";
        case 1:
            return "저 자";
        case 2:
            return "분 류";
        case 3:
            return "대여 여부";
        }
        return super.getColumnName(column);
    }

}
