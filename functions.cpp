#include <iostream>
#include <unistd.h>

#define USER_NAME "Student"
#define PIN "1234"

using namespace std;

int option;
string patternOption;
string inputUser = "";
string inputPass;

int space()
{
    cout << "\n";
    return 1;
}

void Menu()
{
    if(!inputUser.empty()){
        cout<<"WELCOME "<<inputUser<<endl;
    }
    cout << "Select one of the following options: \n1.Create Pattern\n2.Login Demo\n3.Terminate \n";
    cin >> option;
    switch (option)
    {
        case 1:
            cout << "Choose Pattern character : ";
            cin >> patternOption;
            cout << "Choose Shape of pattern: \n1.Square\n2.Tringle\n3.Rectangle" << endl;
            cin >> option;
            space();
            if (option == 1)
            {
                cout << "What is the dimension of the Square: ";
                cin >> option;
                space();
                for (size_t i = 0; i < option; i++)
                {
                    for (size_t i = 0; i < option; i++)
                    {
                        cout << patternOption;
                    }
                    cout << endl;
                }
            }
            else if (option == 2)
            {
                int height;
                cout << "What is the dimension of the Triangle: ";
                cout << "\nheight: ";
                cin >> height;

                for (size_t i = 0; i < height; i++)
                {
                    for (size_t j = 0; j <= i; j++)
                    {
                        cout << patternOption;
                    }
                    cout << endl;
                }
            }
            else
            {
                int length;
                int width;
                do{
                    if(length ==width){
                        cout <<"Please retry lenth and width cannot be equal"<<endl;
                    }
                    cout << "What is the dimension of the Square: ";
                    cout << "\nwidth: ";
                    cin >> width;
                    cout << "\nlength: ";
                    cin >> length;
                }while (width==length);

                space();
                for (size_t i = 0; i < length; i++)
                {
                    int j = 0;
                    do
                    {
                        cout << patternOption;
                        j++;
                    } while (j < width);

                    cout << endl;
                }
            }
            space();
            Menu();

            break;
        case 2:
            for (int i = 0; i < 3; i++)
            {
                cout << "Enter username : ";
                cin >> inputUser;
                cout << "Enter your password : ";
                cin >> inputPass;
                if (inputUser == USER_NAME && inputPass == PIN)
                {
                    cout << "WELCOME YOU HAVE SUCCESSFULLY LOGGED IN\n"
                         << endl;
                    i = 3;
                    Menu();
                }
                else
                {
                    cout << "INCORRECT USERNAME OR PIN PLEASE TRY AGAIN.\nRemaining: " <<2 -i<< " attempts"<<"\n";

                }
            }
            cout<<"\n\nYOU ARE NOT THE OWNER!!!!!!!!!!!!!\n\n";
            Menu();
            break;
        case 3:

            return;
        default:

            cout << "Invalid Selection\n";
            Menu();
            break;
    }
}

int main()
{
    Menu();
    return 0;
}

