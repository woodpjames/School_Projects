/* Date Made: 11/24/18, Last Mosified: 11/29/18, Programer: James Wood
This program will create a class that can create question objects. It will include 7 fields. 1 question, 4 responses, 1 correct answer,
and 1 boolean variable that will indicate whether the question has been used yet. All of the fields will be able to be accessed and set
through accesor and mutator methods. It will also contain a constructor method that will accept 6 arguments to be set to the 6 individual
fields. All except the boolean Used which will always be initialed as false.*/

public class P3A3_WOOD_4214424_Question
{
	//Creates the field for the question
	private String Q;
	//Next four lines create the fields responsible for storing answer choices
	private String A1;
	private String A2;
	private String A3;
	private String A4;
	//Creates the field for the correct answer
	private String CA;
	//Creates the field that will be used to see if the answer has been asked or not
	private boolean used;

	//This creates the constructor method that will initialize the fields of the question object
	public P3A3_WOOD_4214424_Question(String Q, String A1, String A2, String A3, String A4, String CA)
	{
		this.Q = Q;
		this.A1 = A1;
		this.A2 = A2;
		this.A3 = A3;
		this.A4 = A4;
		this.CA = CA;
		used = false;
	}

	//Mutator method that mutates Answer Choice 1
	public void setA1(String A1)
	{
		this.A1 = A1;
	}
	//Mutator method that mutates Answer Choice 2
	public void setA2(String A2)
	{
		this.A2 = A2;
	}
	//Mutator method that mutates Answer Choice 3
	public void setA3(String A3)
	{
		this.A2 = A2;
	}
	//Mutator method that mutates Answer Choice 4
	public void setA4(String A4)
	{
		this.A2 = A2;
	}
	//Mutator method that mutates the question
	public void setQ(String Q)
	{
		this.Q = Q;
	}
	//Mutator method that mutates the correct answer
	public void setCA(String CA)
	{
		this.CA = CA;
	}
	//Mutator method that mutates boolean used
	public void setUsed(boolean used)
	{
		this.used = used;
	}


	//Accesor method that returns answer choice 1
	public String getA1()
	{
		return A1;
	}
	//Accesor method that returns answer choice 2
	public String getA2()
	{
		return A2;
	}
	//Accesor method that returns answer choice 3
	public String getA3()
	{
		return A3;
	}
	//Accesor method that returns answer choice 4
	public String getA4()
	{
		return A4;
	}
	//Accesor method that returns question
	public String getQ()
	{
		return Q;
	}
	//Accesor method that returns correct answer
	public String getCA()
	{
		return CA;
	}
	//Accesor method that returns boolean used
	public boolean getUsed()
	{
		return used;
	}
}
