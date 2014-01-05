package vue;

import controleur.Controleur;
import vue.dialog.DialogNouveauAnimal;
import vue.dialog.DialogNouveauMonde;
import vue.enums.Animal;
import vue.enums.Decor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Edwin on 19/12/13.
 */
public class ToolBar extends JToolBar implements ActionListener {
    private Fenetre fenetre;
    private Controleur controleur;

    private JButton addMonde;
    private JButton addAnimal;
    private JButton retour;
    private JButton addLion;
    private JButton addLamasticot;
    
    
    private ArrayList<JButton> _listeBoutonsAnimaux;
    private ArrayList<JButton> _listeBoutonsDecor;
    

    public ToolBar(final Fenetre fenetre, final Controleur controleur) {
        super();

        this.fenetre = fenetre;
        this.controleur = controleur;
        this._listeBoutonsAnimaux = new ArrayList<>();
        this._listeBoutonsDecor = new ArrayList<>();

        // Initialisation de la toolbar
        setFloatable(false);
        setOpaque(false);
        setBackground(Color.DARK_GRAY);
        setSize(0, 25);
        setPreferredSize(getSize());

        ImageIcon image;
        // Initialisation du premier niveau

        // Ajout monde
        image = new ImageIcon(this.getClass().getResource("../images/toolbar/globe.png"));
        addMonde = new JButton(image);
        addMonde.addActionListener(this);
        addMonde.setToolTipText("Ajouter au monde...");
        add(addMonde);

        // Ajout animal
        image = new ImageIcon(this.getClass().getResource("../images/toolbar/animal.png"));
        addAnimal = new JButton(image);
        addAnimal.addActionListener(this);
        addAnimal.setToolTipText("Ajouter un animal...");
        add(addAnimal);

        // Initialisation du deuxième niveau
        
        JButton tmpBtn;
        
        
        // ajout de tous les animaux
        Animal[] resourcesAnimaux = Animal.values(); // Récupération des valeurs de l'énumération
        int valuesNumber = resourcesAnimaux.length;
        for (int i = 0 ; i < valuesNumber ; i++) {
          final Animal type = resourcesAnimaux[i];
          image = type.getToolbar();
          tmpBtn = new JButton(image);
         // tmpBtn.addActionListener(this);
          tmpBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                     new DialogNouveauAnimal(fenetre, controleur, type);
                }
            });
          tmpBtn.setToolTipText(type.getPhraseToolbar());
          add(tmpBtn);
          tmpBtn.setVisible(false);
          _listeBoutonsAnimaux.add(tmpBtn);
          
        }
        
        // ajout de tous les éléments de décors
        Decor[] resourcesDecors = Decor.values(); // Récupération des valeurs  de l'énumération
        valuesNumber = resourcesDecors.length;
        for (int i = 0 ; i < valuesNumber ; i++) {
          final Decor type = resourcesDecors[i];
          image = type.getToolbar();
          tmpBtn = new JButton(image);
         // tmpBtn.addActionListener(this);
          tmpBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                     new DialogNouveauMonde(fenetre, controleur, type);
                }
            });
          tmpBtn.setToolTipText(type.getPhraseToolbar());
          add(tmpBtn);
          tmpBtn.setVisible(false);
          _listeBoutonsDecor.add(tmpBtn);
          
        }
        

        
        
        
        
        
        // Retour
        image = new ImageIcon(this.getClass().getResource("../images/toolbar/retour.png"));
        retour = new JButton(image);
        retour.addActionListener(this);
        retour.setToolTipText("Retour...");
        add(retour);
        retour.setVisible(false);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(getBackground());
        g2.fillRect(0, 0, getSize().width, getSize().height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addMonde)) {
            addMonde.setVisible(false);
            addAnimal.setVisible(false);
            for(JButton tmpBtn : _listeBoutonsDecor)
               tmpBtn.setVisible(true);
            retour.setVisible(true);

        }
        else if (e.getSource().equals(addAnimal)) {
            addMonde.setVisible(false);
            addAnimal.setVisible(false);
            for(JButton tmpBtn : _listeBoutonsAnimaux)
               tmpBtn.setVisible(true);
            retour.setVisible(true);
        }
        else if (e.getSource().equals(retour)) {
            addMonde.setVisible(true);
            addAnimal.setVisible(true);
            for(JButton tmpBtn : _listeBoutonsDecor)
               tmpBtn.setVisible(false);
            for(JButton tmpBtn : _listeBoutonsAnimaux)
               tmpBtn.setVisible(false);
            
            retour.setVisible(false);
        }
    }
}
