package algHW;

public class HW05_4109064236_4{
	public static boolean checkLLK(int[][] array) {
	
	int i=0,j=0,k=0,l=0,m=0;//i���Ĥ@�ӰѦ��I������,j���ĤG�ӰѦ��I������,��l�Ҭ������I
	int b;
	int slope;
	boolean ANS = false;
	if(array.length>2) {
	for(i=0;i<array.length-2;i++) {//�Ĥ@�ӰѦ��I
	 int[] ForwardPoint=array[i];
	  for(j=i+1;j<array.length-1;j++){//�����ĤG�ӰѦ��I���Ĥ@�ӥH�~�������A�����Ѧ��I
	  	int[] BackwardPoint=array[j];
	  	
	  	while((BackwardPoint[0]-ForwardPoint[0])==0 && (BackwardPoint[1]-ForwardPoint[1])==0 
	  			&& j<array.length-1) {//�p�G�ĤG���I��Ĥ@���I�ۦP�i�j��
	  		j++;//�ĤG�ӰѦ��I����������Ĥ@�ӰѦ��I���P�Τw�g������˼ƲĤG�Ӥ~�|���X�j��
	  		if(j==array.length-2 && (BackwardPoint[0]-ForwardPoint[0])==0 
	  				&& (BackwardPoint[1]-ForwardPoint[1])==0) {
	  			//��Ѧ��I�b�˼ƲĤG�Ӫ��ɭ�(�˼ƲĤ@�ӭn������I)�A�p�G�٬O��Ĥ@�ӰѦ��I�@��
	  			ANS=false;
	  		}
	  	}
	  	
	  	
	  	
	
	  	if((BackwardPoint[0]-ForwardPoint[0])==0) {//�p�G�ײv�����O0(x-x)(�������u) 0��x
			  for(k=j+1;k<array.length;k++) {
				  //�N�ݦA���᪺�I���S��x�y�ЬۦP�� //�p�Gj++����A�|��o�I����
				  //�ҥH���᪺�����I�n��ĤG�ӰѦ��I�᭱(j����>>>>j+1)
				  int[] TestPoint1=array[k];
				  if((TestPoint1[0]-ForwardPoint[0])==0 && (TestPoint1[1]-ForwardPoint[1])==0 
						  || (TestPoint1[0]-BackwardPoint[0])==0 && (TestPoint1[1]-BackwardPoint[1])==0) {
					  //�����P�_�����I�O�_���ơA�p�G���ơA�����I���Ჾ
				  		//�p�G�ײv�����O0�P���l�Ҭ�(�����|�A�Y�P�@���I)
					  if(k<array.length-1) {
							  k++;//�����P�_�U�@�Ӵ����I	
					  }
			  	   	}
				  if(TestPoint1[0]==ForwardPoint[0] && TestPoint1[1]!=ForwardPoint[1] 
						 || TestPoint1[0]==BackwardPoint[0] && TestPoint1[1]!=BackwardPoint[1] ) {//�]��o�F(?)
					 ANS= true;
				  }
				  
				  if(k==array.length-1) {//������I�b�̫�@�Ӫ��ɭ�(�˼ƲĤ@��)�A
					  if((TestPoint1[0]-ForwardPoint[0])==0 && (TestPoint1[1]-ForwardPoint[1])==0 ||
							  (TestPoint1[0]-BackwardPoint[0])==0 && (TestPoint1[1]-BackwardPoint[1])==0  ) {
						  //�B���ӭӰѦ��I�䤤�@�Ӥ@��			  			
			  			ANS=false;
					  }
			  }
				  
				  if(ANS==true) {
				  break;
				  }
			  }
    	   	}//�ײv��0�����p����
	  
		 else if((BackwardPoint[1]-ForwardPoint[1])==0) {//�p�G�ײv���l�O0(y-y)(���]��u) 1��y
			  for(l=j+1;l<array.length;l++) {//�N�ݦA���᪺�I���S��y�y�ЬۦP��
				  int[] TestPoint2=array[l];
				  if((TestPoint2[0]-ForwardPoint[0])==0 && (TestPoint2[1]-ForwardPoint[1])==0) {
					  //�����P�_�����I�O�_���ơA�p�G���ơA�����I���Ჾ
				  		//�p�G�ײv�����O0�P���l�Ҭ�(�����|�A�Y�P�@���I)
					  if(i<array.length-1) {
							  l++;//�����P�_�U�@�Ӵ����I
					  }
			  	   	}
				  if(TestPoint2[1]==ForwardPoint[1] && TestPoint2[0]!=ForwardPoint[0]) {
					  ANS=true;
				  }
				  if(l==array.length-1) {//������I�b�̫�@�Ӫ��ɭ�(�˼ƲĤ@��)�A
					  if((TestPoint2[0]-ForwardPoint[0])==0 && (TestPoint2[1]-ForwardPoint[1])==0 ||
							  (TestPoint2[0]-BackwardPoint[0])==0 && (TestPoint2[1]-BackwardPoint[1])==0  ) {//�B���ӭӰѦ��I�䤤�@�Ӥ@��
			  			
			  			ANS=false;
			  		}
				  }
				  if(ANS==true) {
				  break;
				  }
			  }
    	   	}//�ײv���l��0�����p����
	 
		 else{	
			 slope=(BackwardPoint[1]-ForwardPoint[1])/ (BackwardPoint[0]-ForwardPoint[0]); //1��y,0��x
			 b=ForwardPoint[1]-slope*ForwardPoint[0];//��{��y=ax+b�����ܦ� b=y-ax
			 for(m=j+1;m<array.length;m++) {
				 int[] TestPoint3=array[m];
				 if(b==TestPoint3[1]-slope*TestPoint3[0]) {
					 ANS=true;
				 }
				 
				 if((TestPoint3[0]-ForwardPoint[0])==0 && (TestPoint3[1]-ForwardPoint[1])==0) {
					  //�����P�_�����I�O�_���ơA�p�G���ơA�����I���Ჾ
				  		//�p�G�ײv�����O0�P���l�Ҭ�(�����|�A�Y�P�@���I)
					 if(m<array.length-1) {
							  m++;//�����P�_�U�@�Ӵ����I	(�p�G�w�g�O�̫�@�Ӵ����I�F�N�S��k�b����)�A�ҥH++������O�A�D�̫�@��
					 }
				    if(m==array.length-1) {//������I�b�̫�@�Ӫ��ɭ�(�˼ƲĤ@��)�A
					   if((TestPoint3[0]-ForwardPoint[0])==0 && (TestPoint3[1]-ForwardPoint[1])==0 ||
						   (TestPoint3[0]-BackwardPoint[0])==0 && (TestPoint3[1]-BackwardPoint[1])==0  ) {
								 //�B���ӭӰѦ��I�䤤�@�Ӥ@��			  			
						  		ANS=false;
						  	}
						}
			  	   	}
				 
				 if(ANS==true) {
					 break;
				 }
			 }
		 }//�ײv����0����
	}//���鵲��
	  if(ANS==true) {
		  break;
	  }
	   }//�~�鵲��
	}
	else {
		ANS=false;
	}
	return ANS;
}
public static void main(String[] args) {//����
    int[][] array={{0,0},{1,1},{2,5},{2,6},{6,8},{3,7},{5,7},{45,7}};
    System.out.printf("[%b] ",checkLLK(array));
	}
}
