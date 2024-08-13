package Studentmanagment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Start {
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		System.out.println("WELCOME TO STUDENT MANAGMENT APP ");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("PRESS 1 TO ADD STUDENT:");
			System.out.println("PRESS 2 TO DELETE STUDENT:");
			System.out.println("PRESS 3 TO DISPLAY STUDENT:");
			System.out.println("PRESS 4 TO EXIT APP:");
			int c=Integer.parseInt(br.readLine());
			if(c==1) {
				//add
				System.out.println("ENTER STUDENT NAME:");
				String name=br.readLine();
				System.out.println("ENTER STUDENT PHONE:");
				String phone=br.readLine();
				System.out.println("ENTER STUDENT CITY:");
				String city=br.readLine();
				//create student object to store student
				Student st=new Student(name,phone,city);
				boolean ans=StudentDao.insertStudentToDB(st);
				if(ans==true) {
					System.out.print("Student is addeded sucessfully>>>");
				}
				else {
					System.out.print("somthing went wrong try agin ");
				}
				System.out.println(st);
			}
			else if(c==2) {
				//delete
				System.out.println("enter Student id to delete:");
				int userId=Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println("Deleted....");
				}
				else 
					System.out.println("somthing went wrong......");
			}
			else if(c==3) {
				//display
				StudentDao.showAllStudent();
			}
			else if(c==4) {
				//exit
				break;
			}
			else {
				System.out.println("YOU ENTERED INVALID OPTION TRY AGAIN..");
			}
		}
	}

	}


