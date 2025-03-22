import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;


public class BookApp {
	static Scanner sc = new Scanner(System.in); 
	static ArrayList <BookDetails>  bookDetailsList; 
	
	// insertion of detail
	private static void addDetails() {
		// TODO Auto-generated method stub
		int bId;
		float pr = 0;
		String bN ,aN ,pD;
		// bId -> bookId
		// pr -> price
		// bN -> bookName
		// aN -> authorName
		// pD -> publishDate
		
		System.out.println("Enter The Book ID");
		bId = sc.nextInt();
		
		while(true) {
			try {
				System.out.println("Enter The Price of Book : ");
				pr = sc.nextFloat();
				if(pr<=0) {
					throw new IllegalArgumentException("Price Should Be More Than Zero");
				}
				break;
			}catch(Exception e) {
				System.out.println("Invalid input: " + e.getMessage() + " Please enter a valid price.");
	            sc.nextLine();
	         }
		}
		System.out.println("Enter The Book Name : ");
		bN = sc.next();
		System.out.println("Enter The Author Name : ");
		aN = sc.next();
		System.out.println("Enter The Publish Date (dd/mm/yyyy): ");
		pD = sc.next();
		
		BookDetails b1 = new BookDetails(bId,pr,bN,aN,pD);
		bookDetailsList.add(b1);
		System.out.println("Book Added Successfully");
	}

	//show details
	private  static void showDetails() {
		if(bookDetailsList.isEmpty()) {
			System.out.println("No Books Available");
			return;
		}
		System.out.println("Details........................");
	    System.out.println("------------------------------------------------------------------------------------");
	    System.out.printf("| %-10s | %-10s | %-20s | %-20s | %-12s |\n", 
	                      "Book ID", "Price", "Book Name", "Author Name", "Publish Date");
	    System.out.println("------------------------------------------------------------------------------------");
	    
	    for (BookDetails b : bookDetailsList) {
	        System.out.printf("| %-10d | %-10.2f | %-20s | %-20s | %-12s |\n", 
	                          b.getBookId(), b.getPrice(), b.getBookName(), b.getAuthorName(), b.getPublishDate());
	    }
	    System.out.println("------------------------------------------------------------------------------------");
	}


	//Delete Details
	private static void deletDetails() {
		// TODO Auto-generated method stub
		System.out.println("Enter Book Id To Delete Record");
		int opt = sc .nextInt();
		boolean found =false;
		Iterator<BookDetails> i1= bookDetailsList.iterator();
		while(i1.hasNext()) {
			BookDetails bD = i1.next() ;
			if(bD.getBookId() == opt) {
				i1.remove();
				System.out.println("Deleted.......");
				found = true;
				break;
			}	
		}
		if(!found) {
			System.out.println("Record Not Found. Please Check Book Id");
		}
	}
	
	//update Student Details
	private static void updateDetails() {
		// TODO Auto-generated method stub
		System.out.println("Enter Book Id To Record");
		int opt = sc .nextInt();
		boolean found = false;
		for(BookDetails b1 : bookDetailsList ) {
			if(b1.getBookId() == opt) {
				System.out.println("Enter The Updated Book Id");
				b1.setBookId(sc.nextInt());
				System.out.println("Enter The Updated Price");
				b1.setPrice(sc.nextFloat());
				System.out.println("Enter The Updated Book Name");
				b1.setBookName(sc.next());
				System.out.println("Enter The Update Author Name");
				b1.setAuthorName(sc.next());
				System.out.println("Enter The Updated Published Date(dd/mm/yyyy");
				System.out.println("Updated Successfully.............................");
				b1.setPublishDate(sc.next());
				found = true;
				break;
			}
		}
		if (!found) {
	        System.out.println("Record Not Found. Please Check Book Id");
	    }
	}
	
	//search book by author name
	private static void bookByAuthor() {
		// TODO Auto-generated method stub
		System.out.println("Enter the author name");
		String opt = sc.next();
		boolean found = false;
		for(BookDetails b : bookDetailsList) {
			if(b.getAuthorName().equalsIgnoreCase(opt)) {
				System.out.println("Book Details.......................");
				System.out.println("------------------------------------------------------------------------------------");
			    System.out.printf("| %-10s | %-10s | %-20s | %-20s | %-12s |\n", 
			                      "Book ID", "Price", "Book Name", "Author Name", "Publish Date");
			    System.out.println("------------------------------------------------------------------------------------");
			    
				 System.out.printf("| %-10d | %-10.2f | %-20s | %-20s | %-12s |\n", 
                         b.getBookId(), b.getPrice(), b.getBookName(), b.getAuthorName(), b.getPublishDate());
				 System.out.println("------------------------------------------------------------------------------------");
					
				 found = true;
				 break;
			}
		}
		if(!found) {
			System.out.println("No Book Avialable For This Author");
		}
	}

	//search by book id
	private static void bookById() {
		// TODO Auto-generated method stub
		System.out.println("Enter The Book ID");
		int opt = sc.nextInt();
		boolean found = false;
		for(BookDetails b : bookDetailsList) {
			if(b.getBookId()==opt) {
				System.out.println("Book Details...........................");
				System.out.println("------------------------------------------------------------------------------------");
			    System.out.printf("| %-10s | %-10s | %-20s | %-20s | %-12s |\n", 
			                      "Book ID", "Price", "Book Name", "Author Name", "Publish Date");
			    System.out.println("------------------------------------------------------------------------------------");
			   
				System.out.printf("| %-10d | %-10.2f | %-20s | %-20s | %-12s |\n", 
                         b.getBookId(), b.getPrice(), b.getBookName(), b.getAuthorName(), b.getPublishDate());
				
				System.out.println("------------------------------------------------------------------------------------");
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("No Book Avialable For This Author");
		}
	}
	
	//expensive Book
		private static void expensiveBook() {
			// TODO Auto-generated method stub
			if(bookDetailsList.isEmpty()) {
				System.out.println("No Books Available..");
				return ;
			}
			BookDetails b  = Collections.max(bookDetailsList , new ExpensiveBook());
			System.out.println("Expensive Book....");
			System.out.println("------------------------------------------------------------------------------------");
		    System.out.printf("| %-10s | %-10s | %-20s | %-20s | %-12s |\n", 
		                      "Book ID", "Price", "Book Name", "Author Name", "Publish Date");
		    System.out.println("------------------------------------------------------------------------------------");
		    System.out.printf("| %-10d | %-10.2f | %-20s | %-20s | %-12s |\n", 
	                   b.getBookId(), b.getPrice(), b.getBookName(), b.getAuthorName(), b.getPublishDate());
			
			System.out.println("------------------------------------------------------------------------------------");
		
		}
		
	//cheapest book
		private static void cheapestBook() {
			// TODO Auto-generated method stub
			if(bookDetailsList.isEmpty()) {
				System.out.println("No Books Available....");
			}
			BookDetails b = Collections.min(bookDetailsList , new CheapestBook());
			System.out.println("Cheapest Book ...");
			System.out.println("------------------------------------------------------------------------------------");
		    System.out.printf("| %-10s | %-10s | %-20s | %-20s | %-12s |\n", 
		                      "Book ID", "Price", "Book Name", "Author Name", "Publish Date");
		    System.out.println("------------------------------------------------------------------------------------");
		    System.out.printf("| %-10d | %-10.2f | %-20s | %-20s | %-12s |\n", 
	                   b.getBookId(), b.getPrice(), b.getBookName(), b.getAuthorName(), b.getPublishDate());
			
			System.out.println("------------------------------------------------------------------------------------");
		
		}
		
	//search Book by name
		private static void bookByName() {
			// TODO Auto-generated method stub
			System.out.println("Enter the book name");
			String opt = sc.next().toLowerCase();
			boolean found = false;
			for(BookDetails b : bookDetailsList) {
				if(b.getBookName().toLowerCase().contains(opt)) {
					System.out.println("Book Details.............");
					System.out.println("------------------------------------------------------------------------------------");
				    System.out.printf("| %-10s | %-10s | %-20s | %-20s | %-12s |\n", 
				                      "Book ID", "Price", "Book Name", "Author Name", "Publish Date");
				    System.out.println("------------------------------------------------------------------------------------");
				   
					System.out.printf("| %-10d | %-10.2f | %-20s | %-20s | %-12s |\n", 
	                         b.getBookId(), b.getPrice(), b.getBookName(), b.getAuthorName(), b.getPublishDate());
					
					System.out.println("------------------------------------------------------------------------------------");
					found = true;
					break;
				}
			}
			if(!found) {
				System.out.println("No Book Avialable For This Author");
			}
			
			
			
		}
	//sort by id
	private static void sortById() {
		// TODO Auto-generated method stub
		System.out.println("Sorted By Id................");
		System.out.println("------------------------------------------------------------------------------------");
	    System.out.printf("| %-10s | %-10s | %-20s | %-20s | %-12s |\n", 
	                      "Book ID", "Price", "Book Name", "Author Name", "Publish Date");
	    System.out.println("------------------------------------------------------------------------------------");
	    
		Collections.sort(bookDetailsList);
		for(BookDetails b : bookDetailsList) {
			 System.out.printf("| %-10d | %-10.2f | %-20s | %-20s | %-12s |\n", 
                     b.getBookId(), b.getPrice(), b.getBookName(), b.getAuthorName(), b.getPublishDate());
		}
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	//sort by name
	private static void sortByAuthorName() {
		// TODO Auto-generated method stub
		System.out.println("Sorted by author name ..........");
		System.out.println("------------------------------------------------------------------------------------");
	    System.out.printf("| %-10s | %-10s | %-20s | %-20s | %-12s |\n", 
	                      "Book ID", "Price", "Book Name", "Author Name", "Publish Date");
	    System.out.println("------------------------------------------------------------------------------------");
	    
		Collections.sort(bookDetailsList , new AuthorName());
		for(BookDetails b: bookDetailsList) {
			 System.out.printf("| %-10d | %-10.2f | %-20s | %-20s | %-12s |\n", 
                     b.getBookId(), b.getPrice(), b.getBookName(), b.getAuthorName(), b.getPublishDate());
		}
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	// sort by price
	private static void sortByPrice() {
		// TODO Auto-generated method stub
		Collections.sort(bookDetailsList , new SortByPrice());
		System.out.println("Sorted by price.............");
		System.out.println("------------------------------------------------------------------------------------");
	    System.out.printf("| %-10s | %-10s | %-20s | %-20s | %-12s |\n", 
	                      "Book ID", "Price", "Book Name", "Author Name", "Publish Date");
	    System.out.println("------------------------------------------------------------------------------------");
	    
	    for(BookDetails b : bookDetailsList) {
	    	System.out.printf("| %-10d | %-10.2f | %-20s | %-20s | %-12s |\n", 
                    b.getBookId(), b.getPrice(), b.getBookName(), b.getAuthorName(), b.getPublishDate());
		}
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	// sort by book name
	private static void sortByBookName() {
		// TODO Auto-generated method stub
		Collections.sort(bookDetailsList,new SortByBookName());
		
		System.out.println("Sorted by book name..........");
		System.out.println("------------------------------------------------------------------------------------");
	    System.out.printf("| %-10s | %-10s | %-20s | %-20s | %-12s |\n", 
	                      "Book ID", "Price", "Book Name", "Author Name", "Publish Date");
	    System.out.println("------------------------------------------------------------------------------------");
	    for(BookDetails b : bookDetailsList) {
	    	System.out.printf("| %-10d | %-10.2f | %-20s | %-20s | %-12s |\n", 
                    b.getBookId(), b.getPrice(), b.getBookName(), b.getAuthorName(), b.getPublishDate());
		}
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	//Count of Books 
	private static void countBooks() {
		// TODO Auto-generated method stub
		System.out.println("Books Available In System : "+bookDetailsList.size());
	}
	
	//main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bookDetailsList = new ArrayList();
		int opt =0;
		do {
			System.out.println("-------------------------------------------------");
			System.out.println("1. To add details");
			System.out.println("-------------------------------------------------");
			System.out.println("2. To review details");
			System.out.println("-------------------------------------------------");
			System.out.println("3. To delete details");
			System.out.println("-------------------------------------------------");
			System.out.println("4. To update details");
			System.out.println("-------------------------------------------------");
			System.out.println("5. To search books written by specific author");
			System.out.println("-------------------------------------------------");
			System.out.println("6. To search book by id");
			System.out.println("-------------------------------------------------");
			System.out.println("7. To search book by name");
			System.out.println("-------------------------------------------------");
			System.out.println("8. To search cheapest book");
			System.out.println("-------------------------------------------------");
			System.out.println("9. To search expensive book");
			System.out.println("-------------------------------------------------");
			System.out.println("10. To sort details by id");
			System.out.println("-------------------------------------------------");
			System.out.println("11. To sort book by author name");
			System.out.println("-------------------------------------------------");
			System.out.println("12. To sort book by price");
			System.out.println("-------------------------------------------------");
			System.out.println("13. To sort book by book name");
			System.out.println("-------------------------------------------------");
			System.out.println("14. To count books available");
			System.out.println("-------------------------------------------------");
			System.out.println("15. Exit");
			System.out.println("-------------------------------------------------");
			System.out.println("Enter any one option to start system");
			System.out.println("-------------------------------------------------");
			
			opt = sc.nextInt();
			switch(opt) {
			case 1: addDetails();
				break;
			case 2: showDetails();
				break;
			case 3: deletDetails();
				break;
			case 4 : updateDetails();
				break;
			case 5 : bookByAuthor();
				break;
			case 6 : bookById();
				break;
			case 7 : bookByName();
				break;
			case 8 :cheapestBook();
				break;
			case 9 :expensiveBook();
				break;
			case 10 : sortById();
				break;
			case 11: sortByAuthorName();
				break;
			case 12 : sortByPrice();
				break;
			case 13 : sortByBookName();
				break;
			case 14 :countBooks();
				break;
			case 15: System.out.println("Exit");
				break;
				
			default :
				System.out.println("Wrong Input");
			}
		}
		while(opt!=15); 
	}
}
