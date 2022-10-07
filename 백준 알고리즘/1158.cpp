#include <iostream>
#include <stdlib.h>

using namespace std;

typedef struct node {
    int data;
    struct node *next;
} node;

void add_node(node **head, int item)
{
    node *plus = (node *)malloc(sizeof(node));
    plus->data = item;
    
    if((*head) == NULL)
    {
        (*head) = plus;
        plus->next = plus;
    }
    else
    {
        plus->next = (*head)->next;
        (*head)->next = plus;
        (*head) = plus;
    }
}

void delete_node (node **head, int n, int k, int *answer)
{
    node *temp=NULL;
    int back;

    for(int i=0; i < n; i++)
    {
        if(*head == NULL)
            cout << "Error !" << endl;
        else
        {
            for(int j=0; j < k - 1; j++)
                *head = (*head)->next;
            
            temp = (*head)->next;
            (*head)->next = temp->next;
            back = temp->data;
            free(temp);
            answer[i] = back;
        }
    }
}

int main(int argc, char **argv)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    node *list=NULL;
    int n, k;
    
    cin >> n >> k;
    int answer[n];
    for(int i=1; i <= n; i++)
        add_node(&list, i);
    
    delete_node(&list, n, k, answer);
    
    cout << "<";
    for(int i=0; i < n-1; i++)
        cout << answer[i]<<","<<" ";
    
    cout << answer[n-1] << ">";
    return 0;
}