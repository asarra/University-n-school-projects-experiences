#ifndef SPEEDBOID_H
#define SPEEDBOID_H


class SpeedBoid {
    protected:
        int vx;
        int vy;
        int posX;
        int posY;
        int size;

    public:
        SpeedBoid();

        int getX();
        int getY();
        int getSpeedX();
        int getSpeedY();

        void setPosition(int x, int y);
        void setSpeed(int x, int y);
        void move();
        void draw();

};

#endif // SPEEDBOID_H
