package com.example.pasarela_backend.service;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;

@Service
public class MercadoPagoService {

    // Inyectar el token de acceso desde el archivo de configuración
    @Value("${mercadopago.access.token}")
    private String accessToken;

    public String crearPreferencia(int cantidadBolsas) throws Exception {
        try {
            // Configurar el Access Token de MercadoPago
            MercadoPagoConfig.setAccessToken(accessToken);

            // Crear un cliente de preferencia
            PreferenceClient client = new PreferenceClient();

            // Crear ítems en la preferencia
            PreferenceItemRequest item = PreferenceItemRequest.builder()
                    .title("Bolsas de Pan")
                    .quantity(cantidadBolsas)
                    .unitPrice(new BigDecimal(6000)) // Precio por bolsa: 6000 COP
                    .currencyId("COP") // Moneda
                    .build();

            // Crear la solicitud de preferencia con los ítems
            PreferenceRequest request = PreferenceRequest.builder()
                    .items(Collections.singletonList(item))
                    .build();

            // Crear la preferencia de pago
            Preference preference = client.create(request);

            // Retornar la URL de pago de MercadoPago
            return preference.getInitPoint();
        } catch (Exception e) {
            throw new Exception("Error creando preferencia en MercadoPago", e);
        }
    }
}
