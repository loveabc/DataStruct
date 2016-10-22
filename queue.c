#include <stdio.h>

typedef int ElementType;

typedef struct QueueNode *Node;
typedef struct Queue *QueueType;

//���нڵ�ṹ 
struct QueueNode{
	ElementType element;//���нڵ������
    Node next;//��һ���ڵ� 
};

//���� 
struct Queue{
	Node first; //ͷָ�� 
	Node rear;//βָ�� 
};

//��ʼ������
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

//����
void EnQueue(QueueType queue,ElementType element){
	Node node;
	if(queue==NULL){
		printf("%s","���в�����");
	}else{
		node=(Node)malloc(sizeof(Node));
		if(node==NULL){
			printf("%s","����ռ�ʧ��");
		}else{
			node->element=element;
			node->next=NULL;
			queue->rear->next=node;
			queue->rear=node;
		}
		
	}
	
} 

//����
void ImQueue(QueueType queue){
	Node tmp;
	if(queue->first==queue->rear){
		printf("%s\n","�ն�");
	}else{
		tmp=queue->first;
		queue->first=queue->first->next;
		printf("%d\n",tmp->next->element);
		free(tmp);
	}
} 

//���ٶ���
void DestroyQueue(QueueType queue){
	if(queue==NULL){
		printf("%s","�Ӳ�����");
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
//�ж϶����Ƿ�Ϊ��
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
