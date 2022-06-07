package TheCode;

import javax.swing.JOptionPane;

public class BinaryToInteger {
	
	private static String str = JOptionPane.showInputDialog(null, "Would you like to convert a Binary to int or int to Binary(type int to start with int and binary to start with binary");

	
	public static void main(String[] args) {
		if(str.equalsIgnoreCase("binary")) {
			binaryToInt();
		}
		else if(str.equalsIgnoreCase("int")) {
			IntToBinary();
		}
	}

	private static void IntToBinary() {
		boolean bool = true;
		while(bool == true) {
			String s = JOptionPane.showInputDialog(null, "input your number(255 max)");
			if(Integer.parseInt(s) > 255) {
				JOptionPane.showMessageDialog(null, "the number is too large, 256 is the limit");
			}
			if(Integer.parseInt(s) <= 255) {
				bool = false;
			}
			
			if (bool == false) {
				String integer = s;
				String[] ToBeBinary = new String[8];
				String halfway = "";
				String newnum = "";
				double pow = 1;
				int intVal = (int) (128*pow);
				
				for(int i = 0; i < 8; i++) {
					if(Integer.parseInt(integer)/intVal > 0) {
						halfway += 1 + " ";
						newnum += String.valueOf(intVal) + " ";
						integer = String.valueOf(Integer.parseInt(integer)-intVal);
						pow /= 2;
						intVal = (int) (128*pow);
					}
					else {
						halfway += "0 ";
						newnum += "0" + " ";
						pow /= 2;
						intVal = (int) (128*pow);
					}
				}
				JOptionPane.showMessageDialog(null, s + "\n" + String.valueOf(newnum) + "\n" + halfway + "\n" + "your binary number is: " + halfway) ;

			}
		}
	}

	private static void binaryToInt() {
		boolean bool = true;
		boolean h = false;
		boolean t = true;
		while(bool == true) {
			String s = JOptionPane.showInputDialog(null, "input your binary number of 8 digits");
			if(s.contains("2") || s.contains("3") || s.contains("4") || s.contains("5") || s.contains("6") || s.contains("7") || s.contains("8") || s.contains("9")) {
				JOptionPane.showMessageDialog(null, "the number contains a digit that is not 1 or 0");
				h = true;
			}
			if(s.length() > 8) {
				JOptionPane.showMessageDialog(null, "the number has too many digits,(must be 8)");
				t = false;
			}
			if(s.length() < 8) {
				JOptionPane.showMessageDialog(null, "the number has too little digits,(must be 8)");
				t = false;
			}
			if(t == true && h == false) {
				bool = false;
			}
			t=true;
			h=false;
			
			if (bool == false) {
				String halfway = "";
				int newnum = 0;
				double pow = 1;
				int intVal = (int) (128*pow);
				
				for(int i = 0; i < 7; i++) {
					if(s.substring(i,i+1).equals("1")) {
						halfway += String.valueOf(intVal) + " ";
						pow /= 2;
						intVal = (int) (128*pow);
					}
					else {
						pow /= 2;
						intVal = (int) (128*pow);
						halfway += "0 ";
					}		
				}
				if(s.substring(7,8).equals("1")) {
					halfway += String.valueOf(intVal) + " ";
				}
				else if(s.substring(7,8).equals("0")) {
					halfway += 0 + " ";
				}
				if(halfway.contains("128")) {
					newnum += 128;
				}
				if(halfway.contains("64")) {
					newnum += 64;
				}
				if(halfway.contains("32")) {
					newnum += 32;
				}
				if(halfway.contains("16")) {
					newnum += 16;
				}
				if(halfway.substring(halfway.length()-8,halfway.length()).contains("8")) {
					newnum += 8;
				}
				if(halfway.substring(halfway.length()-8,halfway.length()).contains("4")) {
					newnum += 4;
				}
				if(halfway.substring(halfway.length()-8,halfway.length()).contains("2")) {
					newnum += 2;
				}
				if(halfway.substring(halfway.length()-8,halfway.length()).contains("1")) {
					newnum += 1;
				}
				
				
				String sum = "";
				
				
				if(halfway.contains("128")) {
					sum += "128 +";
				}
				if(halfway.contains("64")) {
					sum += "64 + ";
				}
				if(halfway.contains("32")) {
					sum += "32 + ";
				}
				if(halfway.contains("16")) {
					sum += "16 + ";
				}
				if(halfway.substring(halfway.length()-8,halfway.length()).contains("8")) {
					sum += "8 + ";
				}
				if(halfway.substring(halfway.length()-8,halfway.length()).contains("4")) {
					sum += "4 + ";
				}
				if(halfway.substring(halfway.length()-8,halfway.length()).contains("2")) {
					sum += "2 + ";
				}
				if(halfway.substring(halfway.length()-8,halfway.length()).contains("1")) {
					sum += "1 + ";
				}
				sum += "0 =" + String.valueOf(newnum);
				JOptionPane.showMessageDialog(null, s + "\n" + halfway + "\n" + sum + "\n" + "your number is: " + String.valueOf(newnum)) ;
			}
		}
	}
}

