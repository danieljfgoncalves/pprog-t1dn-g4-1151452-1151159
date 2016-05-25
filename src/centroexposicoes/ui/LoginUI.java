/*
 * Fornece as classe que controlam a interface gráfica.
 */
package centroexposicoes.ui;

import centroexposicoes.controller.LoginController;
import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.model.Fae;
import centroexposicoes.model.FicheiroCentroExposicoes;
import centroexposicoes.model.ListaFaes;
import centroexposicoes.model.ListaOrganizadores;
import centroexposicoes.model.Organizador;
import centroexposicoes.model.Representante;
import centroexposicoes.model.Utilizador;
import centroexposicoes.ui.components.GlobalJFrame;
import centroexposicoes.ui.components.ModelListAtor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Interface gráfica para o login da aplicação.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class LoginUI extends GlobalJFrame {

    private CentroExposicoes centroExposicoes;
    private ListaFaes listaFaes;
    private ListaOrganizadores listaOrganizadores;
    private List<Representante> listaRepresentantes;

    private JLabel lblLista;
    private JList jListAtores;

    private JRadioButton btnFae;
    private JRadioButton btnOrg;
    private JRadioButton btnRep;

    private JButton btnUC3;
    private JButton btnUC4;
    private JButton btnUC5;

    private static final int MARGEM_SUPERIOR = 20, MARGEM_INFERIOR = 20;
    private static final int MARGEM_ESQUERDA = 20, MARGEM_DIREITA = 20;
    private static final Dimension DIMENSAO_JANELA = new Dimension(600, 400);

    public LoginUI(CentroExposicoes centroExposicoes, FicheiroCentroExposicoes ficheiroCE) {

        this.centroExposicoes = centroExposicoes;
        LoginController controller = new LoginController(centroExposicoes);
        this.listaFaes = controller.getListaFaes();
        this.listaOrganizadores = controller.getListaOrganizadores();
        this.listaRepresentantes = controller.getListaRepresentantes();

        criarComponentes();

        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setSize(DIMENSAO_JANELA);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void criarComponentes() {

        add(criarPainelNorte(), BorderLayout.NORTH);
        add(criarPainelCentro(), BorderLayout.CENTER);
        add(criarPainelSul(), BorderLayout.SOUTH);
    }

    private JPanel criarPainelNorte() {

        JPanel pNorte = new JPanel(new BorderLayout());

        pNorte.setBorder(BorderFactory.createEmptyBorder(MARGEM_SUPERIOR,
                MARGEM_ESQUERDA,
                MARGEM_INFERIOR,
                MARGEM_DIREITA));

        JLabel lbl = new JLabel("Selecione o tipo de Utilizador:", JLabel.CENTER);

        btnFae = criarRadioBtnFae();
        btnOrg = criarRadioBtnOrg();
        btnRep = criarRadioBtnRep();

        ButtonGroup rBtnGroup = new ButtonGroup();
        rBtnGroup.add(btnFae);
        rBtnGroup.add(btnOrg);
        rBtnGroup.add(btnRep);

        JPanel panelBotoes = new JPanel(new FlowLayout());
        panelBotoes.add(btnFae);
        panelBotoes.add(btnOrg);
        panelBotoes.add(btnRep);

        pNorte.add(lbl, BorderLayout.NORTH);
        pNorte.add(panelBotoes, BorderLayout.CENTER);

        return pNorte;
    }

    private JPanel criarPainelCentro() {

        JPanel pCentro = new JPanel(new BorderLayout());
        
        this.lblLista = new JLabel("", JLabel.CENTER);
        pCentro.add(this.lblLista);
        
        this.jListAtores = new JList();
        this.jListAtores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.jListAtores.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                btnUC4.setEnabled((btnFae.isSelected()));
                btnUC3.setEnabled((btnOrg.isSelected()));
                btnUC5.setEnabled((btnRep.isSelected()));
            }
        });

        JScrollPane jScroll = new JScrollPane(this.jListAtores);
        
        pCentro.add(jScroll, BorderLayout.SOUTH);

        pCentro.setBorder(BorderFactory.createEmptyBorder(MARGEM_SUPERIOR,
                MARGEM_ESQUERDA,
                MARGEM_INFERIOR,
                MARGEM_DIREITA));

        return pCentro;
    }

    private JPanel criarPainelSul() {

        JPanel pSul = new JPanel(new FlowLayout(FlowLayout.CENTER));

        this.btnUC3 = criarBtnUC3();
        this.btnUC4 = criarBtnUC4();
        this.btnUC5 = criarBtnUC5();

        disableBotoesUCs();
        pSul.add(this.btnUC3);
        pSul.add(this.btnUC4);
        pSul.add(this.btnUC5);

        pSul.setBorder(BorderFactory.createEmptyBorder(MARGEM_SUPERIOR,
                MARGEM_ESQUERDA,
                MARGEM_INFERIOR,
                MARGEM_DIREITA));

        return pSul;
    }

    private JRadioButton criarRadioBtnFae() {

        JRadioButton rBtnFAE = new JRadioButton("FAE");

        rBtnFAE.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                lblLista.setText("Selecione um FAE da lista:");

                jListAtores.setModel(new ModelListAtor(listaFaes.getListaFaes()));

                boolean t = (!jListAtores.isSelectionEmpty());

                disableBotoesUCs();
            }
        });

        return rBtnFAE;
    }

    private JRadioButton criarRadioBtnOrg() {

        JRadioButton rBtnOrganizador = new JRadioButton("Organizador");

        rBtnOrganizador.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                lblLista.setText("Selecione um Organizador da lista:");

                jListAtores.setModel(new ModelListAtor(listaOrganizadores.getListaOrganizadores()));

                disableBotoesUCs();
            }
        });

        return rBtnOrganizador;
    }

    private JRadioButton criarRadioBtnRep() {

        JRadioButton rBtnRepresentante = new JRadioButton("Representante");

        rBtnRepresentante.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                lblLista.setText("Selecione um Representante da lista:");

                jListAtores.setModel(new ModelListAtor(listaRepresentantes));

                disableBotoesUCs();
            }
        });

        return rBtnRepresentante;
    }

    private JButton criarBtnUC3() {

        JButton btn = new JButton("UC3 - Atribuir");

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

                Organizador org = listaOrganizadores.getListaOrganizadores().get(jListAtores.getSelectedIndex());

                // TODO
//                new AtribuirCandidaturaUI(centroExposicoes, org);
            }
        });

        return btn;
    }

    private JButton criarBtnUC4() {

        JButton btn = new JButton("UC4 - Avaliar");

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

                Fae fae = listaFaes.getListaFaes().get(jListAtores.getSelectedIndex());

                // TODO
//                new AvaliarCandidaturaUI(centroExposicoes, fae);
            }
        });

        return btn;
    }

    private JButton criarBtnUC5() {

        JButton btn = new JButton("UC5 - Registar");

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

                Representante rep = listaRepresentantes.get(jListAtores.getSelectedIndex());

                new RegistarCandidaturaUI(centroExposicoes, rep);
            }
        });

        return btn;
    }

    private void disableBotoesUCs() {
        btnUC5.setEnabled(false);
        btnUC3.setEnabled(false);
        btnUC4.setEnabled(false);
    }

    public static void main(String[] args) {

//        List<Fae> lf = new ArrayList<Fae>();
//        lf.add(new Fae(new Utilizador("Ivo", "email", "ivo", "pass")));
//        lf.add(new Fae(new Utilizador("Daniel", "email", "ivo", "pass")));
//        ListaFaes lFae = new ListaFaes(lf);
//
//        List<Organizador> lo = new ArrayList<>();
//        lo.add(new Organizador(new Utilizador("Eric", "email", "ivo", "pass")));
//        lo.add(new Organizador(new Utilizador("Ricardo", "email", "ivo", "pass")));
//        lo.add(new Organizador(new Utilizador("Renato", "email", "ivo", "pass")));
//        ListaOrganizadores lOrg = new ListaOrganizadores(lo);
//
//        List<Representante> lr = new ArrayList<>();
//        lr.add(new Representante(new Utilizador("Bob", "email", "ivo", "pass")));
//
//        CentroExposicoes ce = new CentroExposicoes();
//
//        new LoginUI(ce, lFae, lOrg, lr);
    }
}
