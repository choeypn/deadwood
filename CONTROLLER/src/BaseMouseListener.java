package CONTROLLER.src;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class BaseMouseListener implements MouseListener{
	protected Controller c;

	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
