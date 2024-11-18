package com.example.pasarela_backend.service;

import com.example.pasarela_backend.domain.dto.PagosDTO;
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
public class PagoService {

    // Token de acceso de MercadoPago, inyectado desde el archivo de configuración
    @Value("${mercadopago.access.token}")
    private String accessToken;

    // Método para crear la preferencia de pago
    public String crearPreferencia(int cantidadBolsas) throws Exception {
        try {
            // Configuración de MercadoPago con el token de acceso
            MercadoPagoConfig.setAccessToken(accessToken);

            // Crear los ítems de la preferencia (producto, precio, etc.)
            PreferenceItemRequest item = PreferenceItemRequest.builder()
                    .title("Bolsas de Pan")
                    .quantity(cantidadBolsas)
                    .unitPrice(new BigDecimal(6000)) // Precio por bolsa
                    .currencyId("COP") // Moneda
                    .build();

            // Crear la solicitud de preferencia con los ítems
            PreferenceRequest request = PreferenceRequest.builder()
                    .items(Collections.singletonList(item))
                    .build();

            // Crear el cliente de preferencia
            PreferenceClient client = new PreferenceClient();

            // Enviar la preferencia y obtener el punto de inicio
            Preference preference = client.create(request);

            // Retornar la URL de inicio de pago de MercadoPago
            return preference.getInitPoint();

        } catch (Exception e) {
            // Manejo de excepciones más específico
            throw new Exception("Error creando preferencia en MercadoPago: " + e.getMessage(), e);
        }
    }

    // Método procesarPago que puedes usar para realizar la lógica de procesamiento de pagos
    public PagosDTO procesarPago(Long userId, Double monto, Boolean pagoCompleto) {
        // Crear un nuevo PagosDTO y asignar valores
        PagosDTO pagosDTO = new PagosDTO();
        pagosDTO.setUserId(userId);
        pagosDTO.setMonto(monto);
        pagosDTO.setPagoCompleto(pagoCompleto);

        // Aquí puedes agregar cualquier lógica que necesites (por ejemplo, grabar en base de datos, etc.)

        // Devolver el DTO con los datos procesados
        return pagosDTO;
    }
}
