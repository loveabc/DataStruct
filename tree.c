#include<stdio.h>
//������ ������ 

typedef int ElementType;
typedef struct TreeNode *SearchTree;
struct TreeNode{
	ElementType element;
	SearchTree left;
	SearchTree right;
}; 

typedef struct Queue *Q;
struct Queue{
	SearchTree element;//���е�Ԫ�� 
	Q front;//��ͷ 
	Q rear;//��β 
	Q next;//��һ��Ԫ�� 
};

//�����ն�
Q MakeEmptyQ(){
	return NULL;
} 
//��� 
Q EnQ(Q qt,SearchTree T){
	Q newQ;
	if(qt==NULL){
		qt=(Q)malloc(sizeof(Q));
		qt->element=T;
		qt->front=qt->rear=qt;
		qt->next=NULL;
		return qt;
	}
	newQ=(Q)malloc(sizeof(Q));
	newQ->element=T;
	qt->rear->next=newQ;
	qt->rear=newQ;
	return qt;
}
//����
Q OutQ(Q qt){
	Q oq;
	if(qt==NULL){
		return;
	} 
	oq=qt->front;
	qt->front=oq->next;
	return oq;
} 
//�������
void FindFloor(Q qt,SearchTree T){
	Q oq;
	if(T==NULL){
		return;
	}
	qt=EnQ(qt,T);
	
	while(qt!=NULL){
		oq=OutQ(qt);
		printf("%d\n",oq->element->element);
		if(qt->element->left!=NULL){
			EnQ(qt,qt->element->left);
		}
		if(qt->element->right!=NULL){
			EnQ(qt,qt->element->right);
		}
	}
	
	
} 
//�����ն�����
SearchTree MakeEmpty(SearchTree T){
	if(T!=NULL){
		MakeEmpty(T->left);
		MakeEmpty(T->right);
		free(T);
	}
	return NULL;
} 
//��������
SearchTree Insert(ElementType X,SearchTree T){
	if(T==NULL){
		T=(SearchTree)malloc(sizeof(struct TreeNode));
		if(T==NULL){
			printf("%s\n","Out of space !!!");
			return NULL;
		}else{
			T->element=X;
			T->left=T->right=NULL;
		}
	}else{
		if(X<T->element){
			T->left=Insert(X,T->left);
		}else{
			T->right=Insert(X,T->right);
		}
	}
//	printf("%d\n",T->element);
	return T;
} 

//�������
void FindFirst(SearchTree T){
	
	if(T!=NULL){
		printf("%d ",T->element);
		FindFirst(T->left);
		FindFirst(T->right);
	}
} 
//�������
void FindSecond(SearchTree T){
	
	if(T!=NULL){
		FindSecond(T->left);
		printf("%d ",T->element);
		FindSecond(T->right);
	}
}  
//�������
void FindThird(SearchTree T){
	
	if(T!=NULL){
		FindThird(T->left);
		FindThird(T->right);
		printf("%d ",T->element);
	}
}  
//������Сֵ
SearchTree FindMin(SearchTree T){
	if(T==NULL){
		return NULL;
	}else if(T->left==NULL){
		return T;
	}else{
		return FindMin(T->left);
	}
} 
//�������ֵ
SearchTree FindMax(SearchTree T){
	if(T==NULL){
		return NULL;
	}else if(T->right==NULL){
		return T;
	}else{
		return FindMax(T->right);
	}
}

//����ָ��ֵ
SearchTree FindElement(ElementType X,SearchTree T){
	if(T==NULL){
		return NULL;
	}else if(X<T->element){
		return FindElement(X,T->left);
	}else if(X>T->element){
		return FindElement(X,T->right);
	}else{
		return T;
	}
} 

//ɾ��ָ��Ԫ��
//����ֵ��ɾ���ڵ������������������
//����,ɾ��֮��,������ֵ��Ϊ��ǰ�ڵ������������������ 
SearchTree DeleteElement(ElementType X,SearchTree T){
	SearchTree TmpTree;
	if(T==NULL){
		return NULL; 
	}else if(X<T->element){
		T->left=DeleteElement(X,T->left);
	}else if(X>T->element){
		T->right=DeleteElement(X,T->right);
	}else if(T->left!=NULL&&T->right!=NULL){
		TmpTree=FindMin(T->right);
		T->element=TmpTree->element;
		T->right=DeleteElement(T->element,T->right);
	}else{
		//����ɾ���Ľڵ�ֻ����������������������Ҷ�ӽڵ����� 
		TmpTree=T;
		if(T->left==NULL){
			//���ɾ���Ľڵ�û��������, ���������� ,Ҷ�ӽڵ㷵�ص���NULL 
			T=T->right;
		}else if(T->right==NULL){
			//���ɾ���Ľڵ�ֻ��������,���������� 
			T=T->left;
		}
		free(TmpTree) ;
	}
	return T;
} 
//��K��ڵ�ĸ��� 
int NodesInKFloor(SearchTree T,int k){
	if(T==NULL||k<1){
		return 0;
	}
	if(k==1){
		return 1;
	}
    //�������ڵ����������ڵ�֮�� 
	return NodesInKFloor(T->left,k-1)+NodesInKFloor(T->right,k-1);
} 
//Ҷ�ӽڵ�ĸ���
int NodesInLeaf(SearchTree T) {
	if(T==NULL){
		return 0;
	}
	if(T->left==NULL&&T->right==NULL){
		return 1;
	}
	return NodesInLeaf(T->left)+NodesInLeaf(T->right);
}
//�ж����ö������Ƿ�ͬ��
int IsSame(SearchTree T1,SearchTree T2){
	if(T1==NULL&&T2==NULL){
		//ͬ��
		return 1; 
	}
	if((T1==NULL&&T2!=NULL)||(T1!=NULL&&T2==NULL)){
		//��ͬ��
		return 0; 
	}
	return IsSame(T1->left,T2->left)*IsSame(T1->right,T2->right);
}

int main(){
	int i;
	int nodes;
	SearchTree minElement,maxElement,ElementTree;//��Сֵ,���ֵ 
	Q qt;
	int nums[]={6,2,8,1,4,3};
	
	//����һ�ſ���
	SearchTree T=NULL;
	T=MakeEmpty(T);
	//��������
	 
	for(i=0;i<6;i++){
		T=Insert(nums[i],T);
	}
	//������������
	printf("%s\n","�������");
	FindFirst(T); 
	printf("\n");
	//������� 
	printf("%s\n","�������");
	FindSecond(T);
	printf("\n");
	//�������
	printf("%s\n","�������");
	FindThird(T); 
	printf("\n");
//	printf("%d\n",T->element);
//	printf("%d\n",T->left->element);
//	printf("%d\n",T->right->element);
//	printf("%d\n",T->left->left->element);
//	printf("%d\n",T->left->right->element);
//	printf("%d\n",T->left->right->left->element);
//	T=Insert(5,T);
//	printf("%d\n",T->left->right->right->element);
	
	//��Сֵ
	minElement=FindMin(T); 
	printf("%d\n",minElement->element);
	//���ֵ
	maxElement=FindMax(T); 
	printf("%d\n",maxElement->element);
	
	//����3
	ElementTree=FindElement(3,T);
	if(ElementTree!=NULL){
		printf("%d\n",ElementTree->element);
	}else{
		printf("%s\n","û���ҵ�ֵ");
	}
	//����5 
	ElementTree=FindElement(7,T);
	if(ElementTree!=NULL){
		printf("%d\n",ElementTree->element);
	}else{
		printf("%s\n","û���ҵ�ֵ");
	}
//	ElementTree=DeleteElement(6,T);
//	if(ElementTree!=NULL){
//		FindFirst(T);
//		printf("\n");
//	}
	nodes=NodesInKFloor(T,500);
	printf("%d\n",nodes);
	nodes=NodesInLeaf(T);
	printf("%d\n",nodes);
   	qt=MakeEmptyQ();
   	FindFloor(qt,T);
	return 0;
}
