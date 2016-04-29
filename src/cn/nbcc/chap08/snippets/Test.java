/**
 * 所属包：cn.nbcc.chap08.snippets
 * 文件名：Test.java
 * 创建者：郑哲
 * 创建时间：2016年4月27日 下午9:04:14
 */
package cn.nbcc.chap08.snippets;

import javafx.embed.swt.FXCanvas;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Test {
    private static Scene createScene() {
        Group group = new Group();
        Scene scene = new Scene(group);
        Button button = new Button("JFX Button");
        group.getChildren().add(button);
        return scene;
    }

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        FXCanvas canvas = new FXCanvas(shell, SWT.NONE);
        Scene scene = createScene();
        canvas.setScene(scene);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }
}

