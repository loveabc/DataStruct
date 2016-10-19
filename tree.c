#include<stdio.h>
//������ ������ 

typedef int ElementType;
typedef struct TreeNode *SearchTree;
struct TreeNode{
	ElementType element;
	SearchTree left;
	SearchTree right;
}; 
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
			//���T->left���ǿ�,����T->left,����Ļ������´����Ľڵ�
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

int main(){
	int i;
	SearchTree minElement,maxElement,ElementTree;//��Сֵ,���ֵ 
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
	ElementTree=DeleteElement(6,T);
	if(ElementTree!=NULL){
		FindFirst(T);
		printf("\n");
	}
	return 0;
}
