#include<stdio.h>
//二叉树 搜索树 

typedef int ElementType;
typedef struct TreeNode *SearchTree;
struct TreeNode{
	ElementType element;
	SearchTree left;
	SearchTree right;
}; 
//创建空二叉树
SearchTree MakeEmpty(SearchTree T){
	if(T!=NULL){
		MakeEmpty(T->left);
		MakeEmpty(T->right);
		free(T);
	}
	return NULL;
} 
//插入数据
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
			//如果T->left不是空,返回T->left,否则的话返回新创建的节点
			T->left=Insert(X,T->left);
		}else{
			T->right=Insert(X,T->right);
		}
	}
//	printf("%d\n",T->element);
	return T;
} 

//先序遍历
void FindFirst(SearchTree T){
	
	if(T!=NULL){
		printf("%d ",T->element);
		FindFirst(T->left);
		FindFirst(T->right);
	}
} 
//中序遍历
void FindSecond(SearchTree T){
	
	if(T!=NULL){
		FindSecond(T->left);
		printf("%d ",T->element);
		FindSecond(T->right);
	}
}  
//后序遍历
void FindThird(SearchTree T){
	
	if(T!=NULL){
		FindThird(T->left);
		FindThird(T->right);
		printf("%d ",T->element);
	}
}  
//搜索最小值
SearchTree FindMin(SearchTree T){
	if(T==NULL){
		return NULL;
	}else if(T->left==NULL){
		return T;
	}else{
		return FindMin(T->left);
	}
} 
//搜索最大值
SearchTree FindMax(SearchTree T){
	if(T==NULL){
		return NULL;
	}else if(T->right==NULL){
		return T;
	}else{
		return FindMax(T->right);
	}
}

//搜索指定值
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

//删除指定元素
//返回值是删除节点的左子树或者右子树
//所以,删除之后,将返回值作为当前节点的左子树或者右子树 
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
		//处理被删除的节点只有左子树或者右子树或者叶子节点的情况 
		TmpTree=T;
		if(T->left==NULL){
			//如果删除的节点没有左子树, 返回右子树 ,叶子节点返回的是NULL 
			T=T->right;
		}else if(T->right==NULL){
			//如果删除的节点只有左子树,返回左子树 
			T=T->left;
		}
		free(TmpTree) ;
	}
	return T;
} 

int main(){
	int i;
	SearchTree minElement,maxElement,ElementTree;//最小值,最大值 
	int nums[]={6,2,8,1,4,3};
	
	//创建一颗空树
	SearchTree T=NULL;
	T=MakeEmpty(T);
	//插入数据
	 
	for(i=0;i<6;i++){
		T=Insert(nums[i],T);
	}
	//先序遍历这棵树
	printf("%s\n","先序遍历");
	FindFirst(T); 
	printf("\n");
	//中序遍历 
	printf("%s\n","中序遍历");
	FindSecond(T);
	printf("\n");
	//后序遍历
	printf("%s\n","后序遍历");
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
	
	//最小值
	minElement=FindMin(T); 
	printf("%d\n",minElement->element);
	//最大值
	maxElement=FindMax(T); 
	printf("%d\n",maxElement->element);
	
	//搜索3
	ElementTree=FindElement(3,T);
	if(ElementTree!=NULL){
		printf("%d\n",ElementTree->element);
	}else{
		printf("%s\n","没有找到值");
	}
	//搜索5 
	ElementTree=FindElement(7,T);
	if(ElementTree!=NULL){
		printf("%d\n",ElementTree->element);
	}else{
		printf("%s\n","没有找到值");
	}
	ElementTree=DeleteElement(6,T);
	if(ElementTree!=NULL){
		FindFirst(T);
		printf("\n");
	}
	return 0;
}
