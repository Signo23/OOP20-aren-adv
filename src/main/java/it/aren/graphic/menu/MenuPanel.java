/**
 * 
 */
package it.aren.graphic.menu;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import it.aren.common.BaseActionEnum;
import it.aren.common.BaseObjectEnum;
import it.aren.common.Constant;
import it.aren.common.Settings;
import it.aren.file.SettingsLoader;

/**
 *
 *
 */
public class MenuPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    public MenuPanel() {
        final Settings settings = SettingsLoader.loadSettings();
        final int dimension = Constant.DEFAULT_HITBOX_DIMENSION * settings.scale();
        final MenuButton playButton = new MenuButton(BaseActionEnum.PLAY.getTexture(), "Gioca");
        final MenuButton settingsButton = new MenuButton(BaseActionEnum.SETTINGS.getTexture(), "Impostazioni");
        this.setPreferredSize(settings.getScreenSize());
        this.setLayout(null);

        playButton.setBounds(4 * dimension, 6 * dimension, 8 * dimension, 1 * dimension);
        settingsButton.setBounds(4 * dimension, (int)(7.5 * dimension), 8 * dimension, 1 * dimension);

        this.add(playButton);
        this.add(settingsButton);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.requestFocusInWindow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(BaseObjectEnum.BACKGROUND.getTexture(), 0, 0, this);
    }
}