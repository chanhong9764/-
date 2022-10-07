#include <iostream>
#include <string>

using namespace std;

typedef struct snode {
    int data;
    struct snode *link;
} snode;

typedef struct tops {
    struct snode *top;
} tops;

void init(tops *s)
{
    s->top = NULL;
}

int empty(tops *s)
{
    return (s->top == NULL);
}

void push(tops *s, int item)
{
    snode *temp = (snode *)malloc(sizeof(snode));
    temp->data = item;
    temp->link = s->top;
    s->top = temp;
}

int pop(tops *s)
{
    if(empty(s)) return -1;
    else
    {
    	int back;
    	snode *temp;
    	temp = s->top;
    	back = temp->data;
        s->top = s->top->link;
    	free(temp);
    	return back;
    }
}

int top(tops *s)
{
    if(empty(s)) return -1;
    else return s->top->data;
}

int size(tops *s)
{
    int count=0;
    snode *temp = s->top;
    while(temp != NULL)
    {
        count++;
        temp = temp->link;
    }
    return count;
}
int main(int argc, char **argv)
{
    tops s;
    init(&s);
    int n;
    
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        string input;
        cin >> input;
        
        if(!input.compare("push"))
        {
            int in=0;
            cin >> in;
            push(&s,in);
        }
        else if (!input.compare("pop"))
            cout << pop(&s) << endl;
        else if (!input.compare("size"))
            cout << size(&s) << endl;
        else if (!input.compare("empty"))
            cout << empty(&s) << endl;
        else if (!input.compare("top"))
            cout << top(&s) << endl;
        else
            cout << "Error !" << endl;
    }
    return 0;
}