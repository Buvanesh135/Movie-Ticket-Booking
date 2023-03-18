package List;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

import java.util.Scanner;

public class MTB {

	static List<Movie> movielist = new ArrayList<>();

	static List<Ticke> ticketlist = new ArrayList<>();

	public static void main(String[] args)

	{

		Scanner sc = new Scanner(System.in);

		boolean f = true;

		Movie m1 = new Movie("Master", "2 pm", 150);

		movielist.add(m1);

		Movie m2 = new Movie("Tenet", "10 am", 120);

		movielist.add(m2);

		Movie m3 = new Movie("Valimai", "8 pm", 120);

		movielist.add(m3);

		while (f) {

			System.out.println("\t\t\t\t\t\t\t MOVIE TICKET BOOKING ");

			System.out.println("\t\t\t\t\t\t\t------------------------------");

			System.out.println("\t\t\t\t\t\t\t| 1.Show Movies |");

			System.out.println("\t\t\t\t\t\t\t| 2.Book Ticket |");

			System.out.println("\t\t\t\t\t\t\t| 3.Cancel Ticket |");

			System.out.println("\t\t\t\t\t\t\t| 4.View Ticket |");

			System.out.println("\t\t\t\t\t\t\t| 5.Exit |");

			System.out.println("\t\t\t\t\t\t\t------------------------------");

			System.out.println("enter the choice:");

			int ch = sc.nextInt();

			switch (ch)

			{

			case 1:

				showMovies();

				break;

			case 2:

				MTB.bookticket();

				break;

			case 3:

				MTB.cancelticket();

				break;

			case 4:

				printticket();

				break;

			default:

				f = false;

				break;

			}

		}

	}

	private static void showMovies() {

		for (Movie m : movielist)

		{

			System.out.println("Movies name:" + m.moviename);

		}

	}

	private static void printticket() {

		for (Ticke t : ticketlist)

		{

			System.out.println("ticket id:" + t.ticketid);

			System.out.println("ticket name" + t.moviename);

			System.out.println("ticket cost" + t.ticketcost);

			System.out.println("" + Arrays.toString(t.seating));

		}

	}

	private static void cancelticket() {

		Scanner sc = new Scanner(System.in);

		System.out.println("enter the id to be cancel:");

		int id = sc.nextInt();

		for (Ticke T : ticketlist)

		{

			if (T.ticketid == id)

			{

				for (Movie m : movielist)

				{

					if (m.moviename.equals(T.moviename))

					{

						for (int seatrearrange : T.seating)

						{

							int count = 1;

							for (int i = 1; i <= 10; i++)

							{

								for (int j = 1; j <= 10; j++)

								{

									if (count == seatrearrange)

									{

										m.seat[i][j] = seatrearrange;

										m.totalseat++;

									}

									count++;

								}

							}

						}

					}

				}

				ticketlist.remove(T);

				System.out.println("ticket cancelled successfully");

				break;

			}

		}

	}

	private static void bookticket() {

		Scanner sc = new Scanner(System.in);

		System.out.println("enter the movie Name:");

		String moviename = sc.next();

		int seats = sc.nextInt();

		for (Movie m : movielist)

		{

			if (m.moviename.equals(moviename))

			{

				int[] booked = m.viewticket(seats);

				ticketlist.add(new Ticke(Ticke.id, m.moviename, seats * m.cost, booked));

				System.out.println("Your seat id is:" + Ticke.id);

				System.out.println("Yours seated are :" + Arrays.toString(booked));

				Ticke.id++;

				break;

			}

		}

	}

}