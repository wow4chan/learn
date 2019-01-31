#include <iostream>

using namespace std;

class Logger {
private:
    static Logger *logger;
    Logger() {
        cout << "Create logger instance" << endl;
    }

public:
    ~Logger() {
        cout << "Delete logger instance" << endl;
    }
    static Logger *getInstance() {
        if (logger == NULL) {
            logger = new Logger();
        }
        return logger;
    }
};

Logger *Logger::logger = NULL;

ostream& operator<< (ostream &os, const Logger &logger) {
    os << "Logger instance address is: " << &logger;
    return os;
}

int main(int argc, char *argv[])
{
    Logger *logger1 = Logger::getInstance();
    Logger *logger2 = Logger::getInstance();

    cout << *logger1 << endl;
    cout << *logger2 << endl;

    return 0;
}
