package day14;

public class Book { // class s

  // 1. 멤버변수
  private String bookName; // 책이름
  private String author; // 저자

  // 2. 생성자
  public Book() { 
  } // 기본생성자
  
  public Book(String bookName, String author) { 
    this.bookName = bookName;
    this.author = author;
  } // 멤버변수 초기화 생성자

  // 3. getter, setter
  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  // 3. getter, setter
  

} // class end
