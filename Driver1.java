package homework11;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Driver1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//load data
		//arraylist of objects
		
		ArrayList<person> personobj = new ArrayList<person>();
		 try
	        {
	            FileInputStream fis = new FileInputStream("person.bin");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            personobj = (ArrayList) ois.readObject();
	            ois.close();
	            fis.close();
	         }catch(IOException ioe){
	             ioe.printStackTrace();
	             return;
	          }catch(ClassNotFoundException c){
	             System.out.println("Class not found");
	             c.printStackTrace();
	             return;
	          }
		 
		String name;
		String number;
		String DOB;
		String email;
			
						
	
		System.out.println("Hello Welcome to the Serialization Program.");
			while(true){
				System.out.println("1) Add information into a file.");
				System.out.println("2) Retrieve Information from a file and display it. ");
				System.out.println("3) Delete Information.");
				System.out.println("4) Update Information.");
				System.out.println("5) Exit. ");
					
				System.out.println("Enter your choice: ");
				int choice = scan.nextInt();//accept user input
					
				switch(choice) {
				case 1: 
						//ask for name, #, DOB, and email store in arraylist iterate into .bin then i can display
					
						System.out.print("What is the user's name: ");
						name = scan.next();
						System.out.print("What is their phone number: (xxx)xxx-xxxx");
						number = scan.next();
						System.out.print("What is their date of birth: xx/xx/xxx");
						DOB = scan.next();
						System.out.print("What is their e-mail: ");
						email = scan.next();
					
						//person per = new person(name, number, DOB, email);
						personobj.add(new person(name, number, DOB, email));
						try {
							FileOutputStream fileOut = new FileOutputStream("person.bin");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(personobj);
							out.close();
							fileOut.close();
							System.out.println("\nSerialization Successful...Your File Has Been Updated\n");
			 
						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
						
						System.out.println("Press Enter key to continue...");
						try
					        {
					           System.in.read();
					        }  catch(Exception e) {}
						break;
				case 2: 			
					displayData();
					pressEnterKeyToContinue();
					break;
				case 3: 
					//delete info
					String delete;
					displayData();
					System.out.print("What name would you like to delete: ");
					delete = scan.next();
					
					for(int i = 0; i < personobj.size(); i++){
						if (delete.equals(personobj.get(i).getName()))
						{ 
							personobj.remove(i);
							FileOutputStream fos;
							try {
								fos = new FileOutputStream("person.bin");						
								ObjectOutputStream oos = new ObjectOutputStream(fos);
								oos.writeObject(personobj);
								oos.close();
								}catch (Exception e) {
									e.printStackTrace();}
							
						}
					}
					pressEnterKeyToContinue();
					break;
				case 4: 
					System.out.print("Which entry needs to be updated: ");
					displayData();
					System.out.print("Please enter the name of the entry: ");
					name = scan.next();
					for(int i = 0; i < personobj.size(); i++){
						if(name.equals(personobj.get(i).getName()))
							System.out.println("Which entry needs to be updated: name, number, DOB, or e-mail?");
							String update = scan.next();
							if (update.equals("name"))
							{
								System.out.println("What is the updated name?");
								String newName = scan.next();
								personobj.get(i).setName(newName);
								break;
							}
							else if(update.equals("number"))
							{
								System.out.println("What is the new number?");
								String newNumber = scan.next();
								personobj.get(i).setPhoneNumber(newNumber);
								break;
							}
							else if(update.equals("DOB || dob "))
							{
								System.out.println("What is the updated DOB? xx/xx/xxxx?");
								String newDOB = scan.next();
								personobj.get(i).setDOB(newDOB);
								break;
							}
							else if(update.equals("email || e-mail"))
							{
								System.out.println("What is the new e-mail?");
								String newEmail = scan.next();
								personobj.get(i).setEmailAddy(newEmail);
								break;
							}
						}
						
						
						//update file
						try {
							FileOutputStream fileOut = new FileOutputStream("person.bin");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(personobj);
							out.close();
							fileOut.close();
							System.out.println("\nSerialization Successful...Your File Has Been Updated\n");
			 
						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
					pressEnterKeyToContinue();
					break;
				case 5:	
					System.out.println("Exiting the application");
					System.exit(0);
					default: System.out.println("Incorrect input!!! Please re-enter choice from our menu");
				}
			}
	}

private static void pressEnterKeyToContinue()
{ 
       System.out.println("Press Enter key to continue...");
       try
       {
           System.in.read();
       }  
       catch(Exception e)
       {}  
}

private static void displayData() {
	try {
		FileInputStream fileIn = new FileInputStream("person.bin");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		System.out.println("Deserialized Data: \n" + in.readObject().toString());
		in.close();
		fileIn.close();
	} catch (ClassNotFoundException | IOException e) {
		System.out.println(e.getMessage());
	}
}
}