package main.java;


public class BowlingGame {
	public int getBowlingScore(String bowlingCode){
		String str =bowlingCode;
		int[] scores = new int[12];
		int[] temp=new int[str.length()*2];
		int sum =0;
		int count=0;
		
		for (int i = 0; i < str.length() ; i++) {
			if ((str.charAt(i)) !='|'){
				if((str.charAt(i)) == 'X'){
					temp[count] = 10;
					temp[count+1] = 0;
					count+=2;
				}
				if((str.charAt(i)) == '/'){
					temp[count] = 10-temp[count-1];
					count+=1;
				}
				if((str.charAt(i)) == '-'){
					temp[count] = 0;
					count+=1;
				}
				if((str.charAt(i)) != 'X'& (str.charAt(i)) !='/'&(str.charAt(i)) !='-'){
					char c = str.charAt(i);
					temp[count] = Character.getNumericValue(c);
					count+=1;
				}

			}
		}
		
		
		for(int i=0;i<temp.length;i++){
			System.out.println(temp[i]);
		}
		//计算scores[]数组，即每轮得分
		count=0;
		int num=0;
		for (int i=0; i<=temp.length;i=i+2){
			if(count>9){
				break;
			}
			if(temp[i] == 10){
				while(temp[i+2]==10 && count <= 9){
					if(temp[i+4]==10){
						scores[count]=30;
					}
					else{
						scores[count]=20+temp[i+4];
					}
					count+=1;
					i=i+2;
				}
				
				if(temp[i+2]!=10 && count <= 9){
					scores[count]=10+temp[i+2]+temp[i+3];
					count=count+1;
				}
			}
			
			else{
				if((temp[i]+temp[i+1]) == 10){
					scores[count]=10+temp[i+2];
					count+=1;
				}
				else{
					scores[count]=temp[i]+temp[i+1];
					count+=1;
				}
				
			}
		}
		
		for(int i =0;i<scores.length;i++){
			sum=sum+scores[i];
		}
		
		return sum;

	}
}


