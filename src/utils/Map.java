package utils;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import dao.ServiceDao;
import entite.Zone;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This sample demonstrates how to load a web page with Google Maps and control
 * it using JxBrowser API.
 */
public class Map {

    public Map() {
    }

    public void maps(int z_id) {
        Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);

//        JTabbedPane tabbedPane = new JTabbedPane();
//        tabbedPane.addTab("Browser One", new BrowserView(browserOne));
        JFrame frame = new JFrame("JxBrowser Google Maps");
//        Tous simplement setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//
//        et non setDefaultCloseOperation(DISPOSE_ON_EXIT);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//EXIT_ON_CLOSE
        frame.add(view, BorderLayout.CENTER);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JPanel p = new JPanel();

        double x;
        double y;
        java.util.List<Zone> obj = new ArrayList();
        ServiceDao pdao = new ServiceDao();
        obj = pdao.findByZone(z_id);
        for (Object o : obj) {
            x = ((Zone) o).getLat();
            y = ((Zone) o).getLon();
            browser.loadURL("https://maps.googleapis.com/maps/api/staticmap?center=" + x + "," + y + "&zoom=12&size=700x500&maptype=roadmap&markers=icone%7Clabel:S%7C" + x + "," + y);

        }
    }
}
