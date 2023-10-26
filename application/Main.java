package application;

import entities.*;
import gui.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Pessoa> pessoas;

    public static void main(String[] args){

        pessoas = new ArrayList<>();
        JFrame frame = new FrameCadastro();
    }
}