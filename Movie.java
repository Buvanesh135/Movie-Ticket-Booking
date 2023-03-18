package List;

import java.util.Scanner;

public class Movie {
	String moviename;

	String Time;

	int cost;

	int totalseat=100;

	int seat[][]=new int[11][11];

	public Movie(String name,String Time,int cost)

	{

	this.moviename=name;

	this.Time=Time;

	this.cost=cost;

	int s=1;

	for(int i=1;i<=10;i++)

	{

	for(int j=1;j<=10;j++)

	{

	this.seat[i][j]=s++;

	}

	}

	}

	public int[] viewticket(int seats) {

	Scanner sc=new Scanner(System.in);

	int booked[]=new int[seats];

	for(int i=0;i<seats;i++)

	{

	System.out.println("enter the seat no "+(i+1)+" person");

	int seatno=sc.nextInt();


	for(int k=1;k<=10;k++)

	{

	for(int j=1;j<=10;j++)

	{

	if(this.seat[k][j]==seatno)

	{

	if(this.seat[j][k]==-1)

	{

	System.out.println("this seat is already booked");

	}

	else

	{

	seat[j][k]=-1;

	this.totalseat--;

	booked[i]=seatno;

	}

	}

	}

	}

	}

	return booked;

	}

	

}
