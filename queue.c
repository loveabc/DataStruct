#include <stdio.h>

typedef int ElementType;

typedef struct QueueNode *Node;
typedef struct Queue *QueueType;

//队列节点结构 
struct QueueNode{
	ElementType element;//队列节点的内容
    Node next;//下一个节点 
};

//队列 
struct Queue{
	Node first; //头指针 
	Node rear;//尾指针 
};

//初始化队列
QueueType initQ(){
	Node node;
	QueueType qt;
	node=(Node)malloc(sizeof(Node));
	if(node==NULL){
		return NULL;
	}
	node->element=-1;
	node->next=NULL;
	qt=(QueueType)malloc(sizeof(QueueType));
	qt->first=qt->rear=node;
	return qt;
} 

//进队
void EnQueue(QueueType queue,ElementType element){
	Node node;
	if(queue==NULL){
		printf("%s","队列不存在");
	}else{
		node=(Node)malloc(sizeof(Node));
		if(node==NULL){
			printf("%s","申请空间失败");
		}else{
			node->element=element;
			node->next=NULL;
			queue->rear->next=node;
			queue->rear=node;
		}
		
	}
	
} 

//出队
void ImQueue(QueueType queue){
	Node tmp;
	if(queue->first==queue->rear){
		printf("%s\n","空队");
	}else{
		tmp=queue->first;
		queue->first=queue->first->next;
		printf("%d\n",tmp->next->element);
		free(tmp);
	}
} 

//销毁队列
void DestroyQueue(QueueType queue){
	if(queue==NULL){
		printf("%s","队不存在");
	}else{
		while(queue->first!=NULL){
			queue->rear=queue->first->next;
			free(queue->first);
			queue->first=queue->rear;
		}
		queue->first=queue->rear=NULL;
	//	free(queue);
	//	queue=NULL;
		
	}
} 
//判断队列是否为空
int IsEmpty(QueueType queue){
	if(queue->first==queue->rear){
		return -1;
	}
	return 1;
} 

int main(){
	QueueType qt=NULL;
	
	qt=initQ(qt);
	
	//ImQueue(qt);
	EnQueue(qt,2);
	
	EnQueue(qt,3);
	EnQueue(qt,4);
	DestroyQueue(qt);
	
	printf("%d\n",IsEmpty(qt));
//	ImQueue(qt);
//	ImQueue(qt);
//	EnQueue(qt,4);
//	DestroyQueue(qt);
//	ImQueue(qt);
//	ImQueue(qt);
	return 0;
}
