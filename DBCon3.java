


import java.util.*;
import java.sql.*;


public class DBCon3 
{


public static void main(String[] args)
 {
	 
	 
	 Scanner s = new Scanner(System.in);
	 try (s;){
	 try
	 {
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Qazmlp01");        
		 
		 //Creating Connection
		 PreparedStatement ps1 = con.prepareStatement("insert into BookDetails52 values(?,?,?,?,?)");          
		 //compilation
		 
		 PreparedStatement ps2 = con.prepareStatement("select * from BookDetails52");	
		 //Compilation
		 
		 PreparedStatement Ps3 = con.prepareStatement("select * from BookDetails52 where bcode=?");
		 
		 PreparedStatement Ps4 = con.prepareStatement("update BookDetails52 set bprice=?,bqty=bqty+? where bcode=?");
		 
		 PreparedStatement ps5  = con.prepareStatement("delete from BookDetails52 where bcode=?");
		 while(true)
		 {
			 System.out.println("****choice****");
			 System.out.println("\t1.AddBookDetails"
			                   +"\n\t2.ViewAllBookDetails"
			                   +"\n\t3.ViewBookByCode"
			                   +"\n\t4.UpdateBookByBookCode(price/qty)"
			                   +"\n\t5.DeleteBookByBookCode"
			                   +"\n\t6.Exit");
			 
		     System.out.println("Enter the Choice:");
		     int choice = Integer.parseInt(s.nextLine());
		 
		     
		     switch(choice)
		     {
		    	 case 1:
		     System.out.println("Enter the BookCode:");
		     String bC = s.nextLine();
		     
		     System.out.println("Enter the BookName:");
		     String bN = s.nextLine();
		     
		     System.out.println("Enter the BookAuthor:");
		     String bA = s.nextLine();
		     
		     System.out.println("Enter the BookPrice:");
		     float bp = Float.parseFloat(s.nextLine());
		     
		     System.out.println("Enter the BookQty:");
		     int bQ = Integer.parseInt(s.nextLine());
		     
		     //Setting data to ps1-object
		     ps1.setString(1, bC);
		     ps1.setString(2, bN);
		     ps1.setString(3, bA); 
		     ps1.setFloat(4, bp);	
		     ps1.setInt(5, bQ);
		    		 
		  int K = ps1.executeUpdate(); //Execution
		  if(K>0)
		  {
			  System.out.println("BookDetails Inserted SuccesFully..");
			  
		  }
		    break;
		     
		 case 2:
			 ResultSet rs = ps2.executeQuery();        //Execution
			 System.out.println("****Book-Details****");
			 
			 while(rs.next())
		{
		System.out.println(rs.getString(1)
				     +"\t"+rs.getString(2)
				     +"\t"+rs.getString(3)
				     +"\t"+rs.getFloat(4)
				     +"\t"+rs.getInt(5)); 
		 }//End of the loop
			 
		     break;
		     
		     
		 case 3:
			 
			 System.out.println("Enter the bookCode:");
			 String code = s.nextLine();
			 
		     //setting data to ps3 Object
		     Ps3.setString(1, code);
		     
		     ResultSet rs2 = Ps3.executeQuery();
		     if(rs2.next())

             System.out.println(rs2.getString(1)+"\t"
		    + rs2.getString(2)+"\t"+
		     rs2.getString(3)+"\t"+
		     rs2.getFloat(4)+"\t"
		    +rs2.getInt(5));
		     
		   
		     else
		     {
		    	 System.out.println("Invalid bookCode");
		     }
		     
		     break;
		     
		     case 4: 
		     
		       System.out.println("Enter the BookCode:");
		       String code2=s.nextLine();
		       Ps3.setString(1, code2);
		       ResultSet rs3 = Ps3.executeQuery();
		       
		     if(rs3.next())
		     {
		       System.out.println("Old Book price:"+rs3.getString(4));
		       System.out.println("Enter the new BookPrice:");
		       float nPrice= Float.parseFloat(s.nextLine());
		       System.out.println("Old BookQty:+rs3.getInt(5)");
		       System.out.println("Enter the New Qty:");
		       int nQty = Integer.parseInt(s.nextLine());
		        
		       Ps4.setFloat(1, nPrice);	    
		       Ps4.setInt(2, nQty);	  
		       Ps4.setString(3, code2);
		       int k2 = Ps4.executeUpdate();
		    
		      if(k2>0)
		      {
		       System.out.println("Book Price and qty Updated..."); 
		      }   
		    	   
		      else
		      {
		       System.out.println("Invalid Book Code..");   
		      }
		     }   
		      break;
		      
		      case 5:
		    	  
		       System.out.println("Enter the Bookcode:");	  
		       String code3 = s.nextLine();
		       Ps3.setString(1, code3);
		       ResultSet rs4 = Ps3.executeQuery();
		       
		     if(rs4.next())
		     {
		    	 ps5.setString(1,code3); 
		    	 int k3 = ps5.executeUpdate();
		    	 
		    	 if(k3>0)
		    	 {
		    		 System.out.println("Book Details deleted succesfully");
		    		 
		    	 }
		    	 
		    	 else
		    	 {
		    		 System.out.println("Invalid Book Code..");
		    	 }
		    	 break;
		     } 

		     
	        case 6:
			 
		     System.out.println("Operation on DB Stoped..");
		     System.exit(0);
		     default:System.out.println("Invalid Choice..");
		     } //End of Switch
            }//End of Loop
	 
	       }
	 
	       catch(Exception e)
	       {
		    e.printStackTrace();
	       }
		    		 
          }//end of try with resource	    		 
		    		 
		    		 
         }

   		}


