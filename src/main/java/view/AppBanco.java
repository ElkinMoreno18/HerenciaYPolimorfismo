package view;

import emuns.TipoCuenta;
import models.CuentaAhorro;
import models.CuentaBancaria;
import models.CuentaCorriente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AppBanco extends JFrame {
    private static JTextField numeroCuentaField;
    private JTextField saldoInicialField;
    private JTextField tasaInteresField;
    private JTextField limiteSobregiroField;
    private JButton crearCuentaButton;
    private JButton retirarButton;
    private JButton depositarButton;
    private JButton agregarInteresButton;
    private JButton buttonTransferir;

    private JButton mostrarCuentas;
    private JLabel saldoLabel;
    private JLabel mensajeLabel;
    private JTable jTable;
    private DefaultTableModel defaultTableModel;
    private CuentaBancaria cuenta;

    private CuentaBancaria cuentaOrigen;
    private CuentaBancaria cuentaDestino;
    private List<CuentaBancaria> cuentasBancarias;
    private JPanel AppBancoPanel;
    private CuentaBancaria cuentaRetirar;
    private CuentaBancaria cuentaDepositar;


    public AppBanco() {
        super("AppBanco");
        cuentasBancarias = new ArrayList<CuentaBancaria>();
        setTitle("Transferencias Bancarias");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(8, 1));

        mensajeLabel = new JLabel();
        saldoLabel = new JLabel();

        //Crear cuenta bancaria
        crearCuentaButton = new JButton("Crear cuenta");
        crearCuentaButton.setBounds(20, 150, 120, 30);
        crearCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearCuenta();
            }
        });
        crearCuentaButton.setVisible(true);
        panel.add(crearCuentaButton);

        // Botón retirar
        retirarButton = new JButton("Retirar");
        retirarButton.setBounds(150, 150, 80, 30);
        retirarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retirar();
            }
        });
        retirarButton.setEnabled(false);
        panel.add(retirarButton);

        // Botón depositar
        depositarButton = new JButton("Depositar");
        depositarButton.setBounds(240, 150, 110, 30);
        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositar();
            }
        });
        depositarButton.setEnabled(false);
        panel.add(depositarButton);

        // Botón agregar interés
        agregarInteresButton = new JButton("Agregar interés");
        agregarInteresButton.setBounds(20, 190, 150, 30);
        agregarInteresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarInteres();
            }
        });
        agregarInteresButton.setEnabled(false);
        panel.add(agregarInteresButton);

        // Botón mostrar cuentas
        mostrarCuentas = new JButton("Mostrar cuentas");
        mostrarCuentas.setBounds(20, 190, 150, 30);
        mostrarCuentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCuentas();
            }
        });
        mostrarCuentas.setEnabled(false);
        panel.add(mostrarCuentas);


        // Botón transferir
        buttonTransferir = new JButton("Transferir");
        buttonTransferir.setBounds(20, 190, 150, 30);
        buttonTransferir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferir();
            }
        });
        buttonTransferir.setEnabled(false);
        panel.add(buttonTransferir);

        add(panel, BorderLayout.SOUTH);
    }

    private void crearCuenta() {

        JDialog cuentaCrear = new JDialog(this, "Información", true);
        JLabel label = new JLabel("Informacion cuentas");
        label.setForeground(Color.black);
        cuentaCrear.add(label);
        this.setVisible(true);
        cuentaCrear.setLayout(new BorderLayout(8, 1));

        JLabel numeroCuentaLabel = new JLabel("Número de cuenta:");
        numeroCuentaLabel.setBounds(20, 20, 120, 20);
        cuentaCrear.add(numeroCuentaLabel);
        numeroCuentaField = new JTextField();
        numeroCuentaField.setBounds(150, 20, 200, 20);
        cuentaCrear.add(numeroCuentaField);

        JLabel saldoInicialLabel = new JLabel("Saldo inicial:");
        saldoInicialLabel.setBounds(20, 50, 120, 20);
        cuentaCrear.add(saldoInicialLabel);
        saldoInicialField = new JTextField();
        saldoInicialField.setBounds(150, 50, 200, 20);
        cuentaCrear.add(saldoInicialField);


        JLabel tasaInteresLabel = new JLabel("Tasa de interés:");
        tasaInteresLabel.setBounds(20, 80, 120, 20);
        cuentaCrear.add(tasaInteresLabel);
        tasaInteresField = new JTextField();
        tasaInteresField.setBounds(150, 80, 200, 20);
        cuentaCrear.add(tasaInteresField);

        JLabel limiteSobregiroLabel = new JLabel("Límite de sobregiro:");
        limiteSobregiroLabel.setBounds(20, 110, 120, 20);
        cuentaCrear.add(limiteSobregiroLabel);
        limiteSobregiroField = new JTextField();
        limiteSobregiroField.setBounds(150, 110, 200, 20);
        cuentaCrear.add(limiteSobregiroField);


        // Crear cuenta bancaria
        JButton btnCrearCuenta = new JButton("Crear cuenta Corriente");
        btnCrearCuenta.setBounds(20, 140, 120, 30);
        btnCrearCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroCuenta = numeroCuentaField.getText();
                double saldoInicial = Double.parseDouble(saldoInicialField.getText());
                double tasaInteres = Double.parseDouble(tasaInteresField.getText());
                double limiteSobregiro = Double.parseDouble(limiteSobregiroField.getText());
                TipoCuenta tipoCuenta = TipoCuenta.CORRIENTE;
                if (saldoInicial >= 0 && tasaInteres >= 0 && limiteSobregiro >= 0) {
                    cuenta = new CuentaCorriente(numeroCuenta, saldoInicial, tipoCuenta, limiteSobregiro);
                    cuentasBancarias.add(cuenta);
                    mensajeLabel.setText("Cuenta creada: " + cuenta.getClass().getSimpleName());
                    saldoLabel.setText("Saldo actual: " + cuenta.getSaldo());
                    agregarInteresButton.setEnabled(false);
                    mostrarCuentas.setEnabled(true);
                    agregarInteresButton.setEnabled(true);
                    retirarButton.setEnabled(true);
                    depositarButton.setEnabled(true);
                    buttonTransferir.setEnabled(true);
//                    panel.add(mensajeLabel);
//                    panel.add(saldoLabel);


                } else {
                    mensajeLabel.setText("Los valores deben ser positivos");
                }
            }
        });
        cuentaCrear.add(btnCrearCuenta, BorderLayout.CENTER);

        JButton btnCrearCuentaAhorros = new JButton("Crear cuenta de Ahorros");
        btnCrearCuentaAhorros.setBounds(20, 140, 120, 30);
        btnCrearCuentaAhorros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroCuenta = numeroCuentaField.getText();
                double saldoInicial = Double.parseDouble(saldoInicialField.getText());
                double tasaInteres = Double.parseDouble(tasaInteresField.getText());
                double limiteSobregiro = Double.parseDouble(limiteSobregiroField.getText());
                if (limiteSobregiro > 0) {
                    JOptionPane.showMessageDialog(null, "Este tipo de cuenta no permite Sobregiro");
                }
                TipoCuenta tipoCuenta = TipoCuenta.AHORROS;
                if (saldoInicial >= 0 && tasaInteres >= 0 && limiteSobregiro >= 0) {
                    cuenta = new CuentaCorriente(numeroCuenta, saldoInicial, tipoCuenta, 0);
                    cuentasBancarias.add(cuenta);
                    mensajeLabel.setText("Cuenta creada: " + cuenta.getClass().getSimpleName());
                    saldoLabel.setText("Saldo actual: " + cuenta.getSaldo());
                    agregarInteresButton.setEnabled(false);
                    mostrarCuentas.setEnabled(true);
                    agregarInteresButton.setEnabled(true);
                    retirarButton.setEnabled(true);
                    depositarButton.setEnabled(true);
                    buttonTransferir.setEnabled(true);
//                    panel.add(mensajeLabel);
//                    panel.add(saldoLabel);


                } else {
                    mensajeLabel.setText("Los valores deben ser positivos");
                }
            }
        });

        cuentaCrear.add(btnCrearCuentaAhorros, BorderLayout.CENTER);
        cuentaCrear.add(btnCrearCuenta, BorderLayout.CENTER);

        cuentaCrear.setLayout(new GridLayout(0, 1, 1, 10));


        cuentaCrear.setSize(500, 500);
        cuentaCrear.setVisible(true);

    }

    private void mostrarCuentas() {
        JDialog dialogo = new JDialog(this, "Información", true);
        JLabel label = new JLabel("Informacion cuentas");
        dialogo.add(label);

        // crear tabla y modelo de tabla
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("id");
        defaultTableModel.addColumn("Numero Cuenta");
        defaultTableModel.addColumn("Saldo");
        defaultTableModel.addColumn("Tipo cuenta");

        // Agregar la tabla a un desplazador

        defaultTableModel.setRowCount(0);

        int identificador = 0;
        for (CuentaBancaria itemCuenta : cuentasBancarias) {
            Object[] fila = {
                    identificador,
                    itemCuenta.getNumeroCuenta(),
                    itemCuenta.getSaldo(),
                    itemCuenta.getTipoCuenta()
            };
            defaultTableModel.addRow(fila);
            identificador++;
        }
        jTable = new JTable(defaultTableModel);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        dialogo.add(jScrollPane);
        dialogo.setSize(500, 500);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    private void depositar() {
        if (cuenta != null) {

            String cuentaDepositarInput = JOptionPane.showInputDialog("Numero de cuenta: ");
            for (CuentaBancaria itemCuenta : cuentasBancarias) {
                if (itemCuenta.getNumeroCuenta().equals(cuentaDepositarInput)) {
                    cuentaDepositar = (itemCuenta);

                }
            }
            double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Cantidad a depositar:"));
            if (cantidad >= 0) {
                cuentaDepositar.depositar(cantidad);
                mensajeLabel.setText("Depósito exitoso");
                saldoLabel.setText("Saldo actual: " + cuentaDepositar.getSaldo());
            } else {
                mensajeLabel.setText("La cantidad debe ser positiva");
            }
        } else {
            mensajeLabel.setText("No hay una cuenta creada");
        }
    }

    private void transferir() {
        if (cuenta != null) {
            String cuentaOrigenInput = JOptionPane.showInputDialog("Cuenta de origen:");
            String cuentaDestinoInput = JOptionPane.showInputDialog("Cuenta de destino:");
            int saldoInput = Integer.parseInt(JOptionPane.showInputDialog("Saldo a transferir:"));

            if (saldoInput >= 0) {
                for (CuentaBancaria itemCuenta : cuentasBancarias) {
                    if (itemCuenta.getNumeroCuenta().equals(cuentaOrigenInput)) {
                        cuentaOrigen = itemCuenta;
                    }
                    if (itemCuenta.getNumeroCuenta().equals(cuentaDestinoInput)) {
                        cuentaDestino = itemCuenta;
                    }
                }

                if ((cuentaOrigen.getSaldo()) - 50000 >= (-50000)) {
                    JOptionPane.showMessageDialog(null, "La transferencia excede el limite de sobregiro");
                } else {
                    double saldoMenos = cuentaOrigen.getSaldo() - saldoInput;
                    double saldoMas = cuentaDestino.getSaldo() + saldoInput;

                    cuentaOrigen.setSaldo(saldoMenos);
                    cuentaDestino.setSaldo(saldoMas);
                    mensajeLabel.setText("Transferencia exitosa");
                    saldoLabel.setText("Saldo actual: " + cuentaDestino.getSaldo());
                }


            } else {
                mensajeLabel.setText("La cantidad debe ser positiva");
            }
        } else {
            mensajeLabel.setText("No hay una cuenta creada");
        }
    }

    private void agregarInteres() {
        if (cuenta != null) {
            if (cuenta instanceof CuentaAhorro) {
                ((CuentaAhorro) cuenta).agregarInteres();
                mensajeLabel.setText("Interés agregado");
                saldoLabel.setText("Saldo actual: " + cuenta.getSaldo());
            } else {
                mensajeLabel.setText("La cuenta no es de ahorro");
            }
        } else {
            mensajeLabel.setText("No hay una cuenta creada");
        }
    }

    private void retirar() {
        if (cuenta != null) {

            String cuentaRetirarInput = JOptionPane.showInputDialog("Numero de cuenta: ");
            for (CuentaBancaria itemCuenta : cuentasBancarias) {
                if (itemCuenta.getNumeroCuenta().equals(cuentaRetirarInput)) {
                    cuentaRetirar = (itemCuenta);

                }
            }

            double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Cantidad a retirar:"));
            if (cantidad >= 0) {
                try {
                    if (cuentaRetirar.retirar(cantidad)) {
                        mensajeLabel.setText("Retiro exitoso");
                        saldoLabel.setText("Saldo actual: " + cuentaRetirar.getSaldo());
                    } else {
                        mensajeLabel.setText("No se pudo retirar, saldo insuficiente");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                mensajeLabel.setText("La cantidad debe ser positiva");
            }
        } else {
            mensajeLabel.setText("No hay una cuenta creada");
        }
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                AppBanco app = new AppBanco();
//                app.setVisible(true);
//            }
//        });
//    }


}
