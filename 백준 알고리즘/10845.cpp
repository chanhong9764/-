#include <iostream>
#include <stdlib.h>
#include <string>

using namespace std;

typedef struct node {
    int data;
    struct node *link;
}node;

typedef struct type {
    struct node *front, *rear;
} type;

void init(type *s)
{
    s->front = s->rear = NULL;
}

int empty(type *s)
{
    return (s->front == NULL);
}

void push_node(type *s, int item)
{
    node *temp = (node *)malloc(sizeof(node));
    temp->data = item;
    temp->link = NULL;
    if(empty(s))
    {
        s->front = temp;
        s->rear = temp;
    }
    else
    {
        s->rear->link = temp;
        s->rear = temp;
    }
}

int pop_node(type *s)
{
    int Redata;
    node *temp = s->front;
    if(empty(s))
        return -1;
    
    Redata = temp->data;
    s->front = s->front->link;
    if(s->front == NULL)
        s->rear = NULL;
    free(temp);
    return Redata;
}

int front_node(type *s)
{
    if(empty(s))
        return -1;
    else
        return s->front->data;
}

int rear_node(type *s)
{
    if(empty(s))
        return -1;
    else
        return s->rear->data;
}

int size_node(type *s)
{
    int count=0;
    node *temp = s->front;
    while(temp != NULL)
    {
        count++;
        temp = temp->link;
    }
    return count;
}

int main(int argc, char **argv)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    type q;
    
    init(&q);
    cin >> n;
    
    for(int i=0; i < n; i++)
    {
        string input;
        cin >>input;
        
        if(input == "push")
        {
            int num;
            cin >>num;
            push_node(&q, num);
        }
        else if(input == "pop")
            cout << pop_node(&q) <<endl;
        else if(input == "size")
            cout << size_node(&q) << endl;
        else if(input == "empty")
            cout << empty(&q) << endl;
        else if(input == "front")
            cout << front_node(&q) << endl;
        else if(input == "back")
            cout << rear_node(&q) << endl;
        else
            cout << "Error !"<<endl;
    }

    return 0;
}