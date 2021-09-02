package kw51.lib.game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import kw51.lib.interfaces.ClickHandler;

/*
 * Helper class to simplify the possible events for actual mouse listeners.
 */
public class MouseListenerTemplate implements MouseListener {
    private final ClickHandler clickHandler;

    MouseListenerTemplate(ClickHandler ch) {
        this.clickHandler = ch;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clickHandler.onClick(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
