#include <iostream>
#include <stdlib.h>
#include <string>

using namespace std;

typedef struct node {
    int data;
    struct node *left;
    struct node *right;
} node;

typedef struct type {
    struct node *head;
    struct node *tail;
} type;

void init(type *s)
{
    s->head = s->tail = NULL;
}

int empty(type *s)
{
    return (s->head == NULL);
}

int front(type *s)
{
    if(empty(s)) return -1;
    else return s->head->data;
}

int back(type *s)
{
    if(empty(s)) return -1;
    else return s->tail->data; 
}

void push_front(type *s, int item)
{
    node *temp = (node *)malloc(sizeof(node));
    temp->data = item;
    if(empty(s))
    {
        temp->left = NULL;
        temp->right = NULL;
        s->head = temp;
        s->tail = temp;
    }
    else
    {
        s->head->left = temp;
        temp->right = s->head;
        temp->left = NULL;
        s->head = temp;
    }
}

void push_back(type *s, int item)
{
    node *temp = (node *)malloc(sizeof(node));
    temp->data = item;
    if(empty(s))
    {
        temp->left = NULL;
        temp->right = NULL;
        s->head = temp;
        s->tail = temp;
    }
    else
    {
        s->tail->right = temp;
        temp->left = s->tail;
        temp->right = NULL;
        s->tail = temp;
    }
}

int pop_front(type *s)
{
    int Redata;
    node *temp;
    if(empty(s))
        return -1;
    else
    {
        temp = s->head;
    	Redata = temp->data;
        s->head = s->head->right;
        free(temp);
        if(s->head == NULL)
            s->tail = NULL;
        else
            s->head->left = NULL;
        return Redata;
    }
}

int pop_back(type *s)
{
    int Redata;
    node *temp;
    if(empty(s))
        return -1;
    else
    {
        temp = s->tail;
        Redata = temp->data;
        s->tail = s->tail->left;
        free(temp);
        if(s->tail == NULL)
            s->head = NULL;
        else
            s->tail->right = NULL;
        return Redata;
    }
}

int size(type *s)
{
    int count=0;
    node *temp = s->head;
    while(temp != NULL)
    {
        count++;
        temp = temp->right;
    }
    return count;
}

int main(int argc, char **argv)
{
    type s;
    init(&s);
    
    int n;
    cin >> n;
    
    for(int i=0; i < n; i++)
    {
        string input;
        cin >> input;
        
        if(input == "push_front")
        {
            int num;
            cin >> num;
            push_front(&s,num);
        }
        else if(input == "push_back")
        {
            int num;
            cin >> num;
            push_back(&s,num);
        }
        else if(input == "pop_front")
            cout << pop_front(&s) <<endl;
        else if(input == "pop_back")
            cout << pop_back(&s) <<endl;
        else if(input == "size")
            cout << size(&s) <<endl;
        else if(input == "empty")
            cout << empty(&s) << endl;
        else if(input == "front")
            cout << front(&s) << endl;
        else if(input == "back")
            cout << back(&s) << endl;
        else
            cout << "Input Error !" <<endl; 
    }
    return 0;
}