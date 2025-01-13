package com.vampbear.jappalyzer;

import java.util.Set;

public class JappalyzerRunner {
    public static void main(String[] args) {
        try {
            String url = "https://enel.com";
            Jappalyzer jappalyzer = new Jappalyzer();
            Set<TechnologyMatch> result = jappalyzer.fromUrl(url);
            System.out.println("Tecnologias detectadas:");
            for (TechnologyMatch tech : result) {
                System.out.println("- Tecnologia: " + tech.getTechnology().getName());
                System.out.println("  Categoria: " + tech.getTechnology().getCPE());
                System.out.println("  Versão: " + tech.getVersion());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
