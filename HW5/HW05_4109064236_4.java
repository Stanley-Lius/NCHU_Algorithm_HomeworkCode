package algHW;

public class HW05_4109064236_4{
	public static boolean checkLLK(int[][] array) {
	
	int i=0,j=0,k=0,l=0,m=0;//i為第一個參考點的順序,j為第二個參考點的順序,其餘皆為測試點
	int b;
	int slope;
	boolean ANS = false;
	if(array.length>2) {
	for(i=0;i<array.length-2;i++) {//第一個參考點
	 int[] ForwardPoint=array[i];
	  for(j=i+1;j<array.length-1;j++){//取的第二個參考點為第一個以外往後推算再做為參考點
	  	int[] BackwardPoint=array[j];
	  	
	  	while((BackwardPoint[0]-ForwardPoint[0])==0 && (BackwardPoint[1]-ForwardPoint[1])==0 
	  			&& j<array.length-1) {//如果第二個點跟第一個點相同進迴圈
	  		j++;//第二個參考點往後推移到跟第一個參考點不同或已經推移到倒數第二個才會跳出迴圈
	  		if(j==array.length-2 && (BackwardPoint[0]-ForwardPoint[0])==0 
	  				&& (BackwardPoint[1]-ForwardPoint[1])==0) {
	  			//當參考點在倒數第二個的時候(倒數第一個要放測試點)，如果還是跟第一個參考點一樣
	  			ANS=false;
	  		}
	  	}
	  	
	  	
	  	
	
	  	if((BackwardPoint[0]-ForwardPoint[0])==0) {//如果斜率分母是0(x-x)(為水平線) 0為x
			  for(k=j+1;k<array.length;k++) {
				  //就看再往後的點有沒有x座標相同的 //如果j++執行，會跟這點重複
				  //所以往後的測試點要比第二個參考點後面(j之後>>>>j+1)
				  int[] TestPoint1=array[k];
				  if((TestPoint1[0]-ForwardPoint[0])==0 && (TestPoint1[1]-ForwardPoint[1])==0 
						  || (TestPoint1[0]-BackwardPoint[0])==0 && (TestPoint1[1]-BackwardPoint[1])==0) {
					  //此為判斷測試點是否重複，如果重複，測試點往後移
				  		//如果斜率分母是0與分子皆為(為重疊，即同一個點)
					  if(k<array.length-1) {
							  k++;//直接判斷下一個測試點	
					  }
			  	   	}
				  if(TestPoint1[0]==ForwardPoint[0] && TestPoint1[1]!=ForwardPoint[1] 
						 || TestPoint1[0]==BackwardPoint[0] && TestPoint1[1]!=BackwardPoint[1] ) {//跑到這了(?)
					 ANS= true;
				  }
				  
				  if(k==array.length-1) {//當測試點在最後一個的時候(倒數第一個)，
					  if((TestPoint1[0]-ForwardPoint[0])==0 && (TestPoint1[1]-ForwardPoint[1])==0 ||
							  (TestPoint1[0]-BackwardPoint[0])==0 && (TestPoint1[1]-BackwardPoint[1])==0  ) {
						  //且跟兩個個參考點其中一個一樣			  			
			  			ANS=false;
					  }
			  }
				  
				  if(ANS==true) {
				  break;
				  }
			  }
    	   	}//斜率為0之情況結束
	  
		 else if((BackwardPoint[1]-ForwardPoint[1])==0) {//如果斜率分子是0(y-y)(為鉛錘線) 1為y
			  for(l=j+1;l<array.length;l++) {//就看再往後的點有沒有y座標相同的
				  int[] TestPoint2=array[l];
				  if((TestPoint2[0]-ForwardPoint[0])==0 && (TestPoint2[1]-ForwardPoint[1])==0) {
					  //此為判斷測試點是否重複，如果重複，測試點往後移
				  		//如果斜率分母是0與分子皆為(為重疊，即同一個點)
					  if(i<array.length-1) {
							  l++;//直接判斷下一個測試點
					  }
			  	   	}
				  if(TestPoint2[1]==ForwardPoint[1] && TestPoint2[0]!=ForwardPoint[0]) {
					  ANS=true;
				  }
				  if(l==array.length-1) {//當測試點在最後一個的時候(倒數第一個)，
					  if((TestPoint2[0]-ForwardPoint[0])==0 && (TestPoint2[1]-ForwardPoint[1])==0 ||
							  (TestPoint2[0]-BackwardPoint[0])==0 && (TestPoint2[1]-BackwardPoint[1])==0  ) {//且跟兩個個參考點其中一個一樣
			  			
			  			ANS=false;
			  		}
				  }
				  if(ANS==true) {
				  break;
				  }
			  }
    	   	}//斜率分子為0之情況結束
	 
		 else{	
			 slope=(BackwardPoint[1]-ForwardPoint[1])/ (BackwardPoint[0]-ForwardPoint[0]); //1為y,0為x
			 b=ForwardPoint[1]-slope*ForwardPoint[0];//方程式y=ax+b移項變成 b=y-ax
			 for(m=j+1;m<array.length;m++) {
				 int[] TestPoint3=array[m];
				 if(b==TestPoint3[1]-slope*TestPoint3[0]) {
					 ANS=true;
				 }
				 
				 if((TestPoint3[0]-ForwardPoint[0])==0 && (TestPoint3[1]-ForwardPoint[1])==0) {
					  //此為判斷測試點是否重複，如果重複，測試點往後移
				  		//如果斜率分母是0與分子皆為(為重疊，即同一個點)
					 if(m<array.length-1) {
							  m++;//直接判斷下一個測試點	(如果已經是最後一個測試點了就沒辦法在往後)，所以++的條件是，非最後一個
					 }
				    if(m==array.length-1) {//當測試點在最後一個的時候(倒數第一個)，
					   if((TestPoint3[0]-ForwardPoint[0])==0 && (TestPoint3[1]-ForwardPoint[1])==0 ||
						   (TestPoint3[0]-BackwardPoint[0])==0 && (TestPoint3[1]-BackwardPoint[1])==0  ) {
								 //且跟兩個個參考點其中一個一樣			  			
						  		ANS=false;
						  	}
						}
			  	   	}
				 
				 if(ANS==true) {
					 break;
				 }
			 }
		 }//斜率不為0結束
	}//內圈結束
	  if(ANS==true) {
		  break;
	  }
	   }//外圈結束
	}
	else {
		ANS=false;
	}
	return ANS;
}
public static void main(String[] args) {//測資
    int[][] array={{0,0},{1,1},{2,5},{2,6},{6,8},{3,7},{5,7},{45,7}};
    System.out.printf("[%b] ",checkLLK(array));
	}
}
