package com.example.Orders.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Orders.DTO.parentDTOs.AddTrackingRequestDTO;
import com.example.Orders.DTO.parentDTOs.AuthorizeOrderRequestDTO;
import com.example.Orders.DTO.parentDTOs.CaptureOrderRequestDTO;
import com.example.Orders.DTO.parentDTOs.ConfirmOrderRequestDTO;
import com.example.Orders.DTO.parentDTOs.CreateOrderRequestDTO;
import com.example.Orders.DTO.parentDTOs.OrderDetailsResponseDTO;
import com.example.Orders.DTO.parentDTOs.UpdateOrderCallbackRequestDTO;
import com.example.Orders.DTO.parentDTOs.UpdateOrderRequestDTO;
import com.example.Orders.DTO.parentDTOs.UpdateTrackingRequestDTO;
import com.example.Orders.DTO.responseDTOs.AddTrackingResponseDTO;
import com.example.Orders.DTO.responseDTOs.AuthorizeOrderResponseDTO;
import com.example.Orders.DTO.responseDTOs.CaptureOrderResponseDTO;
import com.example.Orders.DTO.responseDTOs.ConfirmOrderResponseDTO;
import com.example.Orders.DTO.responseDTOs.CreateOrderResponseDTO;
import com.example.Orders.DTO.responseDTOs.UpdateOrderCallbackResponseDTO;
import com.example.Orders.DTO.responseDTOs.UpdateOrderResponseDTO;
import com.example.Orders.DTO.responseDTOs.UpdateTrackingResponseDTO;
import com.example.Orders.DTO.subchildDTOs.AmountBreakdownDTO;
import com.example.Orders.DTO.subchildDTOs.BillingCycleDTO;
import com.example.Orders.DTO.subchildDTOs.ItemDTO;
import com.example.Orders.DTO.subchildDTOs.PaymentInstructionDTO;
import com.example.Orders.DTO.subchildDTOs.PlatformFeeDTO;
import com.example.Orders.DTO.subchildDTOs.ShippingDetailDTO;
import com.example.Orders.DTO.subchildDTOs.ShippingOptionDTO;
import com.example.Orders.DTO.subparentDTOs.ApplicationContextDTO;
import com.example.Orders.DTO.subparentDTOs.PayerDTO;
import com.example.Orders.DTO.subparentDTOs.PaymentSourceDTO;
import com.example.Orders.DTO.subparentDTOs.PurchaseUnitDTO;
import com.example.Orders.Entity.leaf.Discount;
import com.example.Orders.Entity.leaf.Handling;
import com.example.Orders.Entity.leaf.Insurance;
import com.example.Orders.Entity.leaf.ItemTotal;
import com.example.Orders.Entity.leaf.Name;
import com.example.Orders.Entity.leaf.PreviousNetworkTransactionReference;
import com.example.Orders.Entity.leaf.SetupFee;
import com.example.Orders.Entity.leaf.Shipping;
import com.example.Orders.Entity.leaf.ShippingDiscount;
import com.example.Orders.Entity.leaf.Tax;
import com.example.Orders.Entity.leaf.TaxTotal;
import com.example.Orders.Entity.leaf.UnitAmount;
import com.example.Orders.Entity.leaf.Upc;
import com.example.Orders.Entity.leaf.address;
import com.example.Orders.Entity.leaf.payee;
import com.example.Orders.Entity.leaf.phone;
import com.example.Orders.Entity.leaf.tax_info;
import com.example.Orders.Entity.parent.AddTrackingInformationForAnOrder;
import com.example.Orders.Entity.parent.AuthorizePaymentForOrder;
import com.example.Orders.Entity.parent.CapturePaymentForOrder;
import com.example.Orders.Entity.parent.ConfirmOrder;
import com.example.Orders.Entity.parent.CreateOrder;
import com.example.Orders.Entity.parent.OrderUpdateCallback;
import com.example.Orders.Entity.parent.UpdateOrder;
import com.example.Orders.Entity.parent.UpdateOrderTracker;
import com.example.Orders.Entity.subchild.AmountBreakdown;
import com.example.Orders.Entity.subchild.BillingCycle;
import com.example.Orders.Entity.subchild.Card;
import com.example.Orders.Entity.subchild.Item;
import com.example.Orders.Entity.subchild.PaymentInstruction;
import com.example.Orders.Entity.subchild.PlatformFee;
import com.example.Orders.Entity.subchild.ShippingDetail;
import com.example.Orders.Entity.subchild.ShippingOption;
import com.example.Orders.Entity.subparent.ApplicationContext;
import com.example.Orders.Entity.subparent.Payer;
import com.example.Orders.Entity.subparent.PaymentSource;
import com.example.Orders.Entity.subparent.PurchaseUnit;
import com.example.Orders.Entity.subparent.PurchaseUnitAmount;
import com.example.Orders.Repository.parentRepository.AddTrackingInformationForAnOrderRepository;
import com.example.Orders.Repository.parentRepository.AuthorizePaymentForOrderRepository;
import com.example.Orders.Repository.parentRepository.CapturePaymentForOrderRepository;
import com.example.Orders.Repository.parentRepository.ConfirmOrderRepository;
import com.example.Orders.Repository.parentRepository.CreateOrderRepository;
import com.example.Orders.Repository.parentRepository.OrderUpdateCallbackRepository;
import com.example.Orders.Repository.parentRepository.UpdateOrderRepository;
import com.example.Orders.Repository.parentRepository.UpdateOrderTrackerRepository;
import com.example.Orders.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final CreateOrderRepository createOrderRepository;
    private final UpdateOrderRepository updateOrderRepository;
    private final ConfirmOrderRepository confirmOrderRepository;
    private final AuthorizePaymentForOrderRepository authorizePaymentForOrderRepository;
    private final CapturePaymentForOrderRepository capturePaymentForOrderRepository;
    private final AddTrackingInformationForAnOrderRepository addTrackingInformationForAnOrderRepository;
    private final UpdateOrderTrackerRepository updateOrderTrackerRepository;
    private final OrderUpdateCallbackRepository orderUpdateCallbackRepository;

    @Autowired
    public OrderServiceImpl(
            CreateOrderRepository createOrderRepository,
            UpdateOrderRepository updateOrderRepository,
            ConfirmOrderRepository confirmOrderRepository,
            AuthorizePaymentForOrderRepository authorizePaymentForOrderRepository,
            CapturePaymentForOrderRepository capturePaymentForOrderRepository,
            AddTrackingInformationForAnOrderRepository addTrackingInformationForAnOrderRepository,
            UpdateOrderTrackerRepository updateOrderTrackerRepository,
            OrderUpdateCallbackRepository orderUpdateCallbackRepository) {
        this.createOrderRepository = createOrderRepository;
        this.updateOrderRepository = updateOrderRepository;
        this.confirmOrderRepository = confirmOrderRepository;
        this.authorizePaymentForOrderRepository = authorizePaymentForOrderRepository;
        this.capturePaymentForOrderRepository = capturePaymentForOrderRepository;
        this.addTrackingInformationForAnOrderRepository = addTrackingInformationForAnOrderRepository;
        this.updateOrderTrackerRepository = updateOrderTrackerRepository;
        this.orderUpdateCallbackRepository = orderUpdateCallbackRepository;
    }

    // =============================================================================================
    // BLOCK 1: CREATE ORDER
    // =============================================================================================

    @Override
    public CreateOrderResponseDTO createOrder(
            String payPalRequestId,
            String payPalPartnerAttributionId,
            String payPalClientMetadataId,
            String prefer,
            String authorization,
            String payPalAuthAssertion,
            CreateOrderRequestDTO createOrderRequestDTO) {
        // Step 1: Initialize main entity
        CreateOrder createOrder = new CreateOrder();

        // Step 2 & 3: Map main properties if DTO is not null
        if (createOrderRequestDTO != null) {
            createOrder.setIntent(createOrderRequestDTO.getIntent());

            // Step 4 & 5: Map Nested DTO objects
            if (createOrderRequestDTO.getPayer() != null) {
                createOrder.setPayer(mapPayer(createOrderRequestDTO.getPayer()));
            }

            if (createOrderRequestDTO.getPurchaseUnits() != null) {
                createOrder.setPurchaseUnits(mapPurchaseUnits(createOrderRequestDTO.getPurchaseUnits()));
            }

            if (createOrderRequestDTO.getPaymentSource() != null) {
                createOrder.setPaymentSource(mapPaymentSource(createOrderRequestDTO.getPaymentSource()));
            }

            if (createOrderRequestDTO.getApplicationContext() != null) {
                createOrder.setApplicationContext(mapApplicationContext(createOrderRequestDTO.getApplicationContext()));
            }
        }

        // Step 6: Save the entity using Repository
        createOrder = createOrderRepository.save(createOrder);

        // Step 7: Construct CreateOrderResponseDTO
        CreateOrderResponseDTO responseDTO = new CreateOrderResponseDTO();

        if (createOrder.getCreateOrderId() != null) {
            responseDTO.setId(createOrder.getCreateOrderId().toString());
        }

        responseDTO.setStatus("CREATED");
        responseDTO.setIntent(createOrder.getIntent());

        // Pass back Request DTO inputs into Response DTO based on conventional flow
        if (createOrderRequestDTO != null) {
            responseDTO.setPaymentSource(createOrderRequestDTO.getPaymentSource());
            responseDTO.setPayer(createOrderRequestDTO.getPayer());
            responseDTO.setPurchaseUnits(createOrderRequestDTO.getPurchaseUnits());
        }

        // Step 8: Return Response DTO
        return responseDTO;
    }

    // --- Private Helper Methods for Create Order ---

    private Payer mapPayer(PayerDTO dto) {
        if (dto == null)
            return null;

        Payer payer = new Payer();
        payer.setEmailAddress(dto.getEmailAddress());
        payer.setPayerId(dto.getPayerId());
        payer.setBirthDate(dto.getBirthDate());

        // Map leaf: Name
        if (dto.getName() != null) {
            Name name = new Name();
            name.setGivenName(dto.getName().getGivenName());
            name.setSurname(dto.getName().getSurname());
            payer.setName(name);
        }

        // Map leaf: Phone (uses getResolvedNationalNumber() to handle nested JSON
        // structure)
        if (dto.getPhone() != null) {
            phone p = new phone();
            String resolvedNumber = dto.getPhone().getResolvedNationalNumber();
            p.setNationalNumber(resolvedNumber != null ? resolvedNumber : "0000000000");
            payer.setPhone(p);
        }

        // Map leaf: TaxInfo
        if (dto.getTaxInfo() != null) {
            tax_info ti = new tax_info();
            ti.setTaxId(dto.getTaxInfo().getTaxId() != null ? dto.getTaxInfo().getTaxId() : "0000000");
            ti.setTaxIdType(dto.getTaxInfo().getTaxIdType());
            payer.setTaxInfo(ti);
        }

        // Map leaf: Address
        if (dto.getAddress() != null) {
            address addr = new address();
            addr.setAddressLine1(
                    dto.getAddress().getAddressLine1() != null ? dto.getAddress().getAddressLine1() : "Unknown");
            addr.setAddressLine2(dto.getAddress().getAddressLine2());
            addr.setAdminArea1(dto.getAddress().getAdminArea1());
            addr.setAdminArea2(dto.getAddress().getAdminArea2());
            addr.setPostalCode(dto.getAddress().getPostalCode());
            addr.setCountryCode(dto.getAddress().getCountryCode());
            System.out.println(">>>> DEBUG ADDRESS LINE 1: " + addr.getAddressLine1());
            payer.setAddress(addr);
        }

        return payer;
    }

    private List<PurchaseUnit> mapPurchaseUnits(List<PurchaseUnitDTO> dtos) {
        if (dtos == null)
            return null;

        List<PurchaseUnit> purchaseUnits = new ArrayList<>();
        for (PurchaseUnitDTO dto : dtos) {
            if (dto == null)
                continue;

            PurchaseUnit unit = new PurchaseUnit();
            unit.setReferenceId(dto.getReferenceId());
            unit.setDescription(dto.getDescription());
            unit.setCustomId(dto.getCustomId());
            unit.setInvoiceId(dto.getInvoiceId());
            unit.setSoftDescriptor(dto.getSoftDescriptor());

            // Map Amount with Breakdown
            if (dto.getAmount() != null) {
                unit.setAmount(mapPurchaseUnitAmount(dto.getAmount()));
            }

            // Map Payee
            if (dto.getPayee() != null) {
                payee p = new payee();
                p.setEmailAddress(dto.getPayee().getEmailAddress() != null ? dto.getPayee().getEmailAddress()
                        : "unknown@example.com");
                p.setMerchantId(dto.getPayee().getMerchantId());
                unit.setPayee(p);
            }

            // Map Items
            if (dto.getItems() != null) {
                unit.setItems(mapItems(dto.getItems()));
            }

            // Map Shipping Detail
            if (dto.getShipping() != null) {
                unit.setShipping(mapShippingDetail(dto.getShipping()));
            }

            // Map Payment Instruction
            if (dto.getPaymentInstruction() != null) {
                unit.setPaymentInstruction(mapPaymentInstruction(dto.getPaymentInstruction()));
            }

            // Map Billing Plan (billing_cycles, billing_plan_name, setup_fee)
            if (dto.getBillingPlan() != null) {
                unit.setBillingPlanName(dto.getBillingPlan().getName());
                if (dto.getBillingPlan().getSetupFee() != null) {
                    SetupFee sf = new SetupFee();
                    sf.setCurrencyCode(dto.getBillingPlan().getSetupFee().getCurrencyCode());
                    sf.setValue(dto.getBillingPlan().getSetupFee().getValue());
                    unit.setSetupFee(sf);
                }
                if (dto.getBillingPlan().getBillingCycles() != null) {
                    unit.setBillingCycles(mapBillingCycles(dto.getBillingPlan().getBillingCycles()));
                }
            }

            // Map Supplementary Data (pass through — complex structure, entity handles
            // cascade)
            // Note: SupplementaryData mapping requires deep Level3 mapping; entity will
            // cascade save

            purchaseUnits.add(unit);
        }
        return purchaseUnits;
    }

    private PurchaseUnitAmount mapPurchaseUnitAmount(com.example.Orders.DTO.subparentDTOs.PurchaseUnitAmountDTO dto) {
        if (dto == null)
            return null;

        PurchaseUnitAmount amount = new PurchaseUnitAmount();
        amount.setCurrencyCode(dto.getCurrencyCode());
        amount.setValue(dto.getValue());

        if (dto.getBreakdown() != null) {
            AmountBreakdown breakdown = new AmountBreakdown();
            AmountBreakdownDTO bDto = dto.getBreakdown();

            if (bDto.getItemTotal() != null) {
                ItemTotal it = new ItemTotal();
                it.setCurrencyCode(bDto.getItemTotal().getCurrencyCode());
                it.setValue(bDto.getItemTotal().getValue());
                breakdown.setItemTotal(it);
            }
            if (bDto.getShipping() != null) {
                Shipping s = new Shipping();
                s.setCurrencyCode(bDto.getShipping().getCurrencyCode());
                s.setValue(bDto.getShipping().getValue());
                breakdown.setShipping(s);
            }
            if (bDto.getHandling() != null) {
                Handling h = new Handling();
                h.setCurrencyCode(bDto.getHandling().getCurrencyCode());
                h.setValue(bDto.getHandling().getValue());
                breakdown.setHandling(h);
            }
            if (bDto.getTaxTotal() != null) {
                TaxTotal tt = new TaxTotal();
                tt.setCurrencyCode(bDto.getTaxTotal().getCurrencyCode());
                tt.setValue(bDto.getTaxTotal().getValue());
                breakdown.setTaxTotal(tt);
            }
            if (bDto.getInsurance() != null) {
                Insurance ins = new Insurance();
                ins.setCurrencyCode(bDto.getInsurance().getCurrencyCode());
                ins.setValue(bDto.getInsurance().getValue());
                breakdown.setInsurance(ins);
            }
            if (bDto.getShippingDiscount() != null) {
                ShippingDiscount sd = new ShippingDiscount();
                sd.setCurrencyCode(bDto.getShippingDiscount().getCurrencyCode());
                sd.setValue(bDto.getShippingDiscount().getValue());
                breakdown.setShippingDiscount(sd);
            }
            if (bDto.getDiscount() != null) {
                Discount d = new Discount();
                d.setCurrencyCode(bDto.getDiscount().getCurrencyCode());
                d.setValue(bDto.getDiscount().getValue());
                breakdown.setDiscount(d);
            }
            amount.setBreakdown(breakdown);
        }
        return amount;
    }

    private List<Item> mapItems(List<ItemDTO> dtos) {
        if (dtos == null)
            return null;

        List<Item> items = new ArrayList<>();
        for (ItemDTO dto : dtos) {
            if (dto == null)
                continue;

            Item item = new Item();
            item.setName(dto.getName() != null ? dto.getName() : "Unknown Item");
            item.setQuantity(dto.getQuantity() != null ? dto.getQuantity() : "1");
            item.setDescription(dto.getDescription());
            item.setSku(dto.getSku());
            item.setUrl(dto.getUrl());
            item.setCategory(dto.getCategory());
            item.setImageUrl(dto.getImageUrl());

            if (dto.getUnitAmount() != null) {
                UnitAmount ua = new UnitAmount();
                ua.setCurrencyCode(dto.getUnitAmount().getCurrencyCode());
                ua.setValue(dto.getUnitAmount().getValue());
                item.setUnitAmount(ua);
            }
            if (dto.getTax() != null) {
                Tax tax = new Tax();
                tax.setCurrencyCode(dto.getTax().getCurrencyCode());
                tax.setValue(dto.getTax().getValue());
                item.setTax(tax);
            }
            if (dto.getUpc() != null) {
                Upc upc = new Upc();
                upc.setType(dto.getUpc().getType() != null ? dto.getUpc().getType() : "UPC-A");
                upc.setCode(dto.getUpc().getCode() != null ? dto.getUpc().getCode() : "000000000000");
                item.setUpc(upc);
            }
            items.add(item);
        }
        return items;
    }

    private ShippingDetail mapShippingDetail(ShippingDetailDTO dto) {
        if (dto == null)
            return null;

        ShippingDetail detail = new ShippingDetail();
        detail.setType(dto.getType());
        detail.setEmailAddress(dto.getEmailAddress());

        if (dto.getName() != null) {
            Name name = new Name();
            // ShippingDetail uses full_name in JSON but Name entity has givenName/surname
            if (dto.getName().getFullName() != null) {
                name.setGivenName(dto.getName().getFullName());
                name.setSurname("");
            } else {
                name.setGivenName(dto.getName().getGivenName() != null ? dto.getName().getGivenName() : "Unknown");
                name.setSurname(dto.getName().getSurname() != null ? dto.getName().getSurname() : "");
            }
            detail.setName(name);
        }

        if (dto.getAddress() != null) {
            address addr = new address();
            addr.setAddressLine1(
                    dto.getAddress().getAddressLine1() != null ? dto.getAddress().getAddressLine1() : "Unknown");
            addr.setAddressLine2(dto.getAddress().getAddressLine2());
            addr.setAdminArea1(dto.getAddress().getAdminArea1());
            addr.setAdminArea2(dto.getAddress().getAdminArea2());
            addr.setPostalCode(dto.getAddress().getPostalCode());
            addr.setCountryCode(dto.getAddress().getCountryCode());
            detail.setAddress(addr);
        }

        if (dto.getPhoneNumber() != null) {
            phone p = new phone();
            String resolvedNumber = dto.getPhoneNumber().getResolvedNationalNumber();
            p.setNationalNumber(resolvedNumber != null ? resolvedNumber : "0000000000");
            detail.setPhoneNumber(p);
        }

        if (dto.getOptions() != null) {
            List<ShippingOption> options = new ArrayList<>();
            for (ShippingOptionDTO optDto : dto.getOptions()) {
                if (optDto == null)
                    continue;
                ShippingOption opt = new ShippingOption();
                opt.setId(optDto.getId());
                opt.setLabel(optDto.getLabel());
                opt.setType(optDto.getType());
                opt.setSelected(optDto.getSelected());
                // ShippingOption amount mapping can be added if entity supports it
                options.add(opt);
            }
            detail.setOptions(options);
        }

        return detail;
    }

    private PaymentInstruction mapPaymentInstruction(PaymentInstructionDTO dto) {
        if (dto == null)
            return null;

        PaymentInstruction pi = new PaymentInstruction();
        pi.setDisbursementMode(dto.getDisbursementMode());
        pi.setPayeePricingTierId(dto.getPayeePricingTierId());
        pi.setPayeeReceivableFxRateId(dto.getPayeeReceivableFxRateId());

        if (dto.getPlatformFees() != null) {
            List<PlatformFee> fees = new ArrayList<>();
            for (PlatformFeeDTO feeDto : dto.getPlatformFees()) {
                if (feeDto == null)
                    continue;
                PlatformFee fee = new PlatformFee();
                // PlatformFee entity fields depend on its specific structure
                // Map amount and payee if entity supports them
                fees.add(fee);
            }
            pi.setPlatformFees(fees);
        }

        return pi;
    }

    private List<BillingCycle> mapBillingCycles(List<BillingCycleDTO> dtos) {
        if (dtos == null)
            return null;

        List<BillingCycle> cycles = new ArrayList<>();
        for (BillingCycleDTO dto : dtos) {
            if (dto == null)
                continue;
            BillingCycle cycle = new BillingCycle();
            cycle.setTenureType(dto.getTenureType());
            cycle.setTotalCycles(dto.getTotalCycles());
            cycle.setSequence(dto.getSequence());
            // PricingScheme mapping can be expanded if entity supports it
            cycles.add(cycle);
        }
        return cycles;
    }

    private ApplicationContext mapApplicationContext(ApplicationContextDTO dto) {
        if (dto == null)
            return null;

        ApplicationContext context = new ApplicationContext();
        context.setBrandName(dto.getBrandName());
        context.setLandingPage(dto.getLandingPage());
        context.setShippingPreference(dto.getShippingPreference());
        context.setUserAction(dto.getUserAction());
        context.setReturnUrl(dto.getReturnUrl());
        context.setCancelUrl(dto.getCancelUrl());
        context.setLocale(dto.getLocale());
        context.setPaymentMethodPreference(dto.getPaymentMethodPreference());

        // Map stored_payment_source fields
        if (dto.getStoredPaymentSource() != null) {
            context.setPaymentInitiator(dto.getStoredPaymentSource().getPaymentInitiator());
            context.setPaymentType(dto.getStoredPaymentSource().getPaymentType());
            context.setUsage(dto.getStoredPaymentSource().getUsage());

            if (dto.getStoredPaymentSource().getPreviousNetworkTransactionReference() != null) {
                PreviousNetworkTransactionReference ref = new PreviousNetworkTransactionReference();
                ref.setId(dto.getStoredPaymentSource().getPreviousNetworkTransactionReference().getId());
                String dateStr = dto.getStoredPaymentSource().getPreviousNetworkTransactionReference().getDate();
                if (dateStr != null) {
                    try {
                        ref.setDate(java.time.LocalDate.parse(dateStr));
                    } catch (Exception e) {
                        // Handle non-standard date formats (e.g., "0225") gracefully
                        ref.setDate(java.time.LocalDate.now());
                    }
                }
                ref.setNetwork(dto.getStoredPaymentSource().getPreviousNetworkTransactionReference().getNetwork());
                ref.setAcquirerReferenceNumber(dto.getStoredPaymentSource().getPreviousNetworkTransactionReference()
                        .getAcquirerReferenceNumber());
                context.setPreviousNetworkTransactionReference(ref);
            }
        }

        return context;
    }

    private PaymentSource mapPaymentSource(PaymentSourceDTO dto) {
        if (dto == null)
            return null;

        PaymentSource source = new PaymentSource();
        // Instructor requirement: "Request DTO se attribute get karo aur usko entity me
        // set karo using getters and setters."
        if (dto.getCard() != null) {
            Card card = new Card();
            card.setName(dto.getCard().getName());
            card.setNumber(dto.getCard().getNumber());
            card.setSecurityCode(dto.getCard().getSecurityCode());
            card.setExpiry(dto.getCard().getExpiry());
            card.setType(dto.getCard().getType());
            card.setBrand(dto.getCard().getBrand());
            card.setVaultId(dto.getCard().getVaultId());
            source.setCard(card);
        }

        // Add similar direct getter-setter mappings for other nested child nodes if
        // necessary...

        return source;
    }

    private List<com.example.Orders.Entity.leaf.PatchOperation> mapPatchOperations(
            List<com.example.Orders.DTO.leafDTOs.PatchOperationDTO> dtos) {
        if (dtos == null)
            return null;
        List<com.example.Orders.Entity.leaf.PatchOperation> operations = new ArrayList<>();
        for (com.example.Orders.DTO.leafDTOs.PatchOperationDTO dto : dtos) {
            if (dto == null)
                continue;
            com.example.Orders.Entity.leaf.PatchOperation op = new com.example.Orders.Entity.leaf.PatchOperation();
            op.setOp(dto.getOp());
            op.setPath(dto.getPath());
            op.setFrom(dto.getFrom());
            if (dto.getValue() != null) {
                op.setValue(dto.getValue().toString());
            }
            operations.add(op);
        }
        return operations;
    }

    private com.example.Orders.Entity.leaf.Shipping_address mapShippingAddress(
            com.example.Orders.DTO.leafDTOs.ShippingAddressDTO dto) {
        if (dto == null)
            return null;
        com.example.Orders.Entity.leaf.Shipping_address addr = new com.example.Orders.Entity.leaf.Shipping_address();
        addr.setAddressLine1(dto.getAddressLine1() != null ? dto.getAddressLine1() : "Unknown");
        addr.setAddressLine2(dto.getAddressLine2());
        addr.setAdminArea1(dto.getAdminArea1());
        addr.setAdminArea2(dto.getAdminArea2());
        addr.setPostalCode(dto.getPostalCode());
        addr.setCountryCode(dto.getCountryCode());
        return addr;
    }

    private com.example.Orders.Entity.subchild.ShippingOption mapShippingOption(
            com.example.Orders.DTO.subchildDTOs.ShippingOptionDTO dto) {
        if (dto == null)
            return null;
        com.example.Orders.Entity.subchild.ShippingOption opt = new com.example.Orders.Entity.subchild.ShippingOption();
        opt.setId(dto.getId());
        opt.setLabel(dto.getLabel());
        opt.setType(dto.getType());
        opt.setSelected(dto.getSelected());
        if (dto.getAmount() != null) {
            com.example.Orders.Entity.leaf.amount amt = new com.example.Orders.Entity.leaf.amount();
            amt.setCurrencyCode(dto.getAmount().getCurrencyCode());
            amt.setValue(dto.getAmount().getValue());
            opt.setAmount(amt);
        }
        return opt;
    }

    // =============================================================================================
    // BLOCK 2: SHOW ORDER DETAILS
    // =============================================================================================

    @Override
    public OrderDetailsResponseDTO showOrderDetails(
            String orderId,
            String fields,
            String authorization,
            String payPalAuthAssertion) {

        CreateOrder order = createOrderRepository
                .findById(java.util.UUID.fromString(orderId))
                .orElseThrow(() -> new RuntimeException("Order not found"));

        OrderDetailsResponseDTO responseDTO = new OrderDetailsResponseDTO();

        responseDTO.setId(order.getCreateOrderId().toString());
        responseDTO.setStatus("READ");
        responseDTO.setIntent(order.getIntent());

        responseDTO.setCreateTime(java.time.OffsetDateTime.now().toString());
        responseDTO.setUpdateTime(java.time.OffsetDateTime.now().toString());

        /*
         * PAYER
         */

        if (order.getPayer() != null) {

            PayerDTO payerDTO = new PayerDTO();

            payerDTO.setEmailAddress(order.getPayer().getEmailAddress());
            payerDTO.setPayerId(order.getPayer().getPayerId());
            payerDTO.setBirthDate(order.getPayer().getBirthDate());

            if (order.getPayer().getName() != null) {

                com.example.Orders.DTO.leafDTOs.NameDTO nameDTO = new com.example.Orders.DTO.leafDTOs.NameDTO();

                nameDTO.setGivenName(order.getPayer().getName().getGivenName());
                nameDTO.setSurname(order.getPayer().getName().getSurname());

                nameDTO.setFullName(
                        order.getPayer().getName().getGivenName()
                                + " "
                                + order.getPayer().getName().getSurname());

                payerDTO.setName(nameDTO);
            }

            if (order.getPayer().getPhone() != null) {

                com.example.Orders.DTO.leafDTOs.PhoneDTO phoneDTO = new com.example.Orders.DTO.leafDTOs.PhoneDTO();

                phoneDTO.setNationalNumber(
                        order.getPayer().getPhone().getNationalNumber());

                payerDTO.setPhone(phoneDTO);
            }

            if (order.getPayer().getAddress() != null) {

                com.example.Orders.DTO.leafDTOs.AddressDTO addrDTO = new com.example.Orders.DTO.leafDTOs.AddressDTO();

                addrDTO.setAddressLine1(order.getPayer().getAddress().getAddressLine1());
                addrDTO.setAddressLine2(order.getPayer().getAddress().getAddressLine2());
                addrDTO.setAdminArea1(order.getPayer().getAddress().getAdminArea1());
                addrDTO.setAdminArea2(order.getPayer().getAddress().getAdminArea2());
                addrDTO.setPostalCode(order.getPayer().getAddress().getPostalCode());
                addrDTO.setCountryCode(order.getPayer().getAddress().getCountryCode());

                payerDTO.setAddress(addrDTO);
            }

            responseDTO.setPayer(payerDTO);
        }

        /*
         * PURCHASE UNITS
         */

        if (order.getPurchaseUnits() != null) {

            List<PurchaseUnitDTO> units = new ArrayList<>();

            for (PurchaseUnit unit : order.getPurchaseUnits()) {

                PurchaseUnitDTO dto = new PurchaseUnitDTO();

                dto.setReferenceId(unit.getReferenceId());
                dto.setDescription(unit.getDescription());
                dto.setCustomId(unit.getCustomId());
                dto.setInvoiceId(unit.getInvoiceId());
                dto.setSoftDescriptor(unit.getSoftDescriptor());

                if (unit.getAmount() != null) {

                    com.example.Orders.DTO.subparentDTOs.PurchaseUnitAmountDTO amountDTO = new com.example.Orders.DTO.subparentDTOs.PurchaseUnitAmountDTO();

                    amountDTO.setCurrencyCode(unit.getAmount().getCurrencyCode());
                    amountDTO.setValue(unit.getAmount().getValue());

                    dto.setAmount(amountDTO);
                }

                if (unit.getItems() != null) {

                    List<ItemDTO> items = new ArrayList<>();

                    for (Item item : unit.getItems()) {

                        ItemDTO itemDTO = new ItemDTO();

                        itemDTO.setName(item.getName());
                        itemDTO.setQuantity(item.getQuantity());
                        itemDTO.setDescription(item.getDescription());
                        itemDTO.setSku(item.getSku());

                        items.add(itemDTO);
                    }

                    dto.setItems(items);
                }

                if (unit.getPayee() != null) {

                    com.example.Orders.DTO.leafDTOs.PayeeDTO payeeDTO = new com.example.Orders.DTO.leafDTOs.PayeeDTO();

                    payeeDTO.setEmailAddress(unit.getPayee().getEmailAddress());
                    payeeDTO.setMerchantId(unit.getPayee().getMerchantId());

                    dto.setPayee(payeeDTO);
                }

                units.add(dto);
            }

            responseDTO.setPurchaseUnits(units);
        }

        /*
         * PAYMENT SOURCE
         */

        if (order.getPaymentSource() != null) {

            PaymentSourceDTO ps = new PaymentSourceDTO();

            if (order.getPaymentSource().getCard() != null) {

                com.example.Orders.DTO.subchildDTOs.CardDTO cardDTO = new com.example.Orders.DTO.subchildDTOs.CardDTO();

                cardDTO.setName(order.getPaymentSource().getCard().getName());
                cardDTO.setNumber(order.getPaymentSource().getCard().getNumber());
                cardDTO.setSecurityCode(order.getPaymentSource().getCard().getSecurityCode());
                cardDTO.setExpiry(order.getPaymentSource().getCard().getExpiry());

                ps.setCard(cardDTO);
            }

            responseDTO.setPaymentSource(ps);
        }

        /*
         * LINKS
         */

        List<com.example.Orders.DTO.leafDTOs.LinkDTO> links = new ArrayList<>();

        com.example.Orders.DTO.leafDTOs.LinkDTO self = new com.example.Orders.DTO.leafDTOs.LinkDTO();

        self.setHref("http://localhost:8082/api/orders/showOrderDetails?orderId=" + orderId);
        self.setRel("self");
        self.setMethod("GET");

        links.add(self);

        responseDTO.setLinks(links);

        return responseDTO;
    }

    // =============================================================================================
    // BLOCK 3: UPDATE ORDER
    // =============================================================================================

    @Override
    public UpdateOrderResponseDTO updateOrder(String orderId, String authorization, String payPalAuthAssertion,
            UpdateOrderRequestDTO updateOrderRequestDTO) {
        // Step 1: Initialize main entity
        UpdateOrder entity = new UpdateOrder();

        // Step 2 & 3: Map DTO → Entity
        if (updateOrderRequestDTO != null && !updateOrderRequestDTO.isEmpty()) {
            entity.setPatchOperations(mapPatchOperations(updateOrderRequestDTO));
        }

        // Step 6: Save entity
        entity = updateOrderRepository.save(entity);

        // Step 7: Construct response DTO
        UpdateOrderResponseDTO responseDTO = new UpdateOrderResponseDTO();
        
        if (entity.getId() != null) {
            responseDTO.setId(entity.getId().toString());
        }
        
        responseDTO.setStatus("UPDATED");
        
        // Pass back Request DTO inputs into Response DTO based on conventional flow
        if (updateOrderRequestDTO != null) {
            responseDTO.setPatchOperations(updateOrderRequestDTO);
        }

        // Step 8: Return response
        return responseDTO;
    }

    // =============================================================================================
    // BLOCK 4: CONFIRM ORDER
    // =============================================================================================

    @Override
    public ConfirmOrderResponseDTO confirmOrder(String orderId, String payPalClientMetadataId, String authorization,
            String payPalAuthAssertion, String prefer, ConfirmOrderRequestDTO confirmOrderRequestDTO) {
        // Step 1: Initialize main entity
        ConfirmOrder entity = new ConfirmOrder();

        // Step 2 & 3: Map main properties or nested DTOs
        if (confirmOrderRequestDTO != null) {
            if (confirmOrderRequestDTO.getApplicationContext() != null) {
                entity.setApplicationContext(mapApplicationContext(confirmOrderRequestDTO.getApplicationContext()));
            }
            if (confirmOrderRequestDTO.getPaymentSource() != null) {
                entity.setPaymentSource(mapPaymentSource(confirmOrderRequestDTO.getPaymentSource()));
            }
        }

        // Step 6: Save entity
        entity = confirmOrderRepository.save(entity);

        // Step 7: Construct response DTO
        ConfirmOrderResponseDTO responseDTO = new ConfirmOrderResponseDTO();
        responseDTO.setId(orderId);
        responseDTO.setStatus("CONFIRMED");

        // Pass back Request DTO inputs into Response DTO
        if (confirmOrderRequestDTO != null) {
            responseDTO.setPaymentSource(confirmOrderRequestDTO.getPaymentSource());
        }

        // Step 8: Return response
        return responseDTO;
    }

    // =============================================================================================
    // BLOCK 5: AUTHORIZE ORDER
    // =============================================================================================

    @Override
    public AuthorizeOrderResponseDTO authorizeOrder(String orderId, String payPalRequestId, String prefer,
            String payPalClientMetadataId, String authorization, String payPalAuthAssertion,
            AuthorizeOrderRequestDTO authorizeOrderRequestDTO) {
        // Step 1: Initialize main entity
        AuthorizePaymentForOrder entity = new AuthorizePaymentForOrder();

        // Step 2 & 3: Map main properties or nested DTOs
        if (authorizeOrderRequestDTO != null) {
            if (authorizeOrderRequestDTO.getPaymentSource() != null) {
                entity.setPaymentSource(mapPaymentSource(authorizeOrderRequestDTO.getPaymentSource()));
            }
        }

        // Step 6: Save entity
        entity = authorizePaymentForOrderRepository.save(entity);

        // Step 7: Construct response DTO
        AuthorizeOrderResponseDTO responseDTO = new AuthorizeOrderResponseDTO();
        responseDTO.setId(orderId);
        responseDTO.setStatus("AUTHORIZED");

        // Pass back Request DTO inputs into Response DTO
        if (authorizeOrderRequestDTO != null) {
            responseDTO.setPaymentSource(authorizeOrderRequestDTO.getPaymentSource());
        }

        // Step 8: Return response
        return responseDTO;
    }

    // =============================================================================================
    // BLOCK 6: CAPTURE ORDER
    // =============================================================================================

    @Override
    public CaptureOrderResponseDTO captureOrder(String orderId, String payPalRequestId, String prefer,
            String payPalClientMetadataId, String authorization, String payPalAuthAssertion,
            CaptureOrderRequestDTO captureOrderRequestDTO) {
        // Step 1: Initialize main entity
        CapturePaymentForOrder entity = new CapturePaymentForOrder();

        // Step 2 & 3: Map main properties or nested DTOs
        if (captureOrderRequestDTO != null) {
            if (captureOrderRequestDTO.getPaymentSource() != null) {
                entity.setPaymentSource(mapPaymentSource(captureOrderRequestDTO.getPaymentSource()));
            }
        }

        // Step 6: Save entity
        entity = capturePaymentForOrderRepository.save(entity);

        // Step 7: Construct response DTO
        CaptureOrderResponseDTO responseDTO = new CaptureOrderResponseDTO();
        responseDTO.setId(orderId);
        responseDTO.setStatus("CAPTURED");

        // Pass back Request DTO inputs into Response DTO
        if (captureOrderRequestDTO != null) {
            responseDTO.setPaymentSource(captureOrderRequestDTO.getPaymentSource());
        }

        // Step 8: Return response
        return responseDTO;
    }

    // =============================================================================================
    // BLOCK 7: ADD TRACKING INFORMATION
    // =============================================================================================

    @Override
    public AddTrackingResponseDTO addTracking(String orderId, String authorization, String payPalAuthAssertion,
            AddTrackingRequestDTO addTrackingRequestDTO) {
        // Step 1: Initialize main entity
        AddTrackingInformationForAnOrder entity = new AddTrackingInformationForAnOrder();

        // Step 2 & 3: Map main properties
        if (addTrackingRequestDTO != null) {
            entity.setTrackingNumber(addTrackingRequestDTO.getTrackingNumber());
            entity.setCarrier(addTrackingRequestDTO.getCarrier());
            entity.setCarrierNameOther(addTrackingRequestDTO.getCarrierNameOther());
            entity.setCaptureId(addTrackingRequestDTO.getCaptureId());
            entity.setNotifyPayer(addTrackingRequestDTO.getNotifyPayer());
            if (addTrackingRequestDTO.getItems() != null) {
                entity.setItems(mapItems(addTrackingRequestDTO.getItems()));
            }
        }

        // Step 6: Save entity
        entity = addTrackingInformationForAnOrderRepository.save(entity);

        // Step 7: Construct response DTO
        AddTrackingResponseDTO responseDTO = new AddTrackingResponseDTO();
        if (entity.getId() != null) {
            responseDTO.setTransactionId(entity.getId().toString());
        }
        responseDTO.setStatus("SHIPPED");

        // Pass back Request DTO inputs into Response DTO
        if (addTrackingRequestDTO != null) {
            responseDTO.setTrackingNumber(entity.getTrackingNumber());
            responseDTO.setCarrier(entity.getCarrier());
            responseDTO.setCarrierNameOther(entity.getCarrierNameOther());
            responseDTO.setCaptureId(entity.getCaptureId());
            responseDTO.setNotifyPayer(entity.getNotifyPayer());
            responseDTO.setItems(addTrackingRequestDTO.getItems());
        }

        // Step 8: Return response
        return responseDTO;
    }

    // =============================================================================================
    // BLOCK 8: UPDATE OR CANCEL TRACKING
    // =============================================================================================

    @Override
    public UpdateTrackingResponseDTO updateTracking(String orderId, String trackerId, String authorization,
            String payPalAuthAssertion, UpdateTrackingRequestDTO updateTrackingRequestDTO) {
        // Step 1: Initialize main entity
        UpdateOrderTracker entity = new UpdateOrderTracker();

        // Step 2 & 3: Map DTO → Entity
        if (updateTrackingRequestDTO != null && !updateTrackingRequestDTO.isEmpty()) {
            entity.setPatchOperations(mapPatchOperations(updateTrackingRequestDTO));
        }

        // Step 6: Save entity
        entity = updateOrderTrackerRepository.save(entity);

        // Step 7: Construct response DTO
        UpdateTrackingResponseDTO responseDTO = new UpdateTrackingResponseDTO();
        
        if (entity.getId() != null) {
            responseDTO.setId(entity.getId().toString());
        }
        
        responseDTO.setStatus("UPDATED");
        
        // Pass back Request DTO inputs into Response DTO based on conventional flow
        if (updateTrackingRequestDTO != null) {
            responseDTO.setPatchOperations(updateTrackingRequestDTO);
        }

        // Step 8: Return response
        return responseDTO;
    }

    // =============================================================================================
    // BLOCK 9: UPDATE ORDER CALLBACK
    // =============================================================================================

    @Override
    public UpdateOrderCallbackResponseDTO updateOrderCallback(String authorization,
            UpdateOrderCallbackRequestDTO updateOrderCallbackRequestDTO) {
        // Step 1: Initialize main entity
        OrderUpdateCallback entity = new OrderUpdateCallback();

        // Step 2 & 3: Map DTO → Entity
        if (updateOrderCallbackRequestDTO != null) {
            if (updateOrderCallbackRequestDTO.getPurchaseUnits() != null) {
                entity.setPurchaseUnits(mapPurchaseUnits(updateOrderCallbackRequestDTO.getPurchaseUnits()));
            }
            if (updateOrderCallbackRequestDTO.getShippingAddress() != null) {
                entity.setShippingAddress(mapShippingAddress(updateOrderCallbackRequestDTO.getShippingAddress()));
            }
            if (updateOrderCallbackRequestDTO.getShippingOption() != null) {
                entity.setShippingOption(mapShippingOption(updateOrderCallbackRequestDTO.getShippingOption()));
            }
        }

        // Step 6: Save entity
        entity = orderUpdateCallbackRepository.save(entity);

        // Step 7: Construct response DTO
        UpdateOrderCallbackResponseDTO responseDTO = new UpdateOrderCallbackResponseDTO();

        if (entity.getId() != null) {
            responseDTO.setId(entity.getId().toString());
        }

        responseDTO.setStatus("UPDATED");

        // Pass back Request DTO inputs into Response DTO based on conventional flow
        if (updateOrderCallbackRequestDTO != null) {

            responseDTO.setPurchaseUnits(updateOrderCallbackRequestDTO.getPurchaseUnits());
            responseDTO.setShippingOption(updateOrderCallbackRequestDTO.getShippingOption());

            if (updateOrderCallbackRequestDTO.getShippingAddress() != null) {

                com.example.Orders.DTO.leafDTOs.AddressDTO addrDTO = new com.example.Orders.DTO.leafDTOs.AddressDTO();

                addrDTO.setAddressLine1(updateOrderCallbackRequestDTO.getShippingAddress().getAddressLine1());
                addrDTO.setAddressLine2(updateOrderCallbackRequestDTO.getShippingAddress().getAddressLine2());
                addrDTO.setAdminArea1(updateOrderCallbackRequestDTO.getShippingAddress().getAdminArea1());
                addrDTO.setAdminArea2(updateOrderCallbackRequestDTO.getShippingAddress().getAdminArea2());
                addrDTO.setPostalCode(updateOrderCallbackRequestDTO.getShippingAddress().getPostalCode());
                addrDTO.setCountryCode(updateOrderCallbackRequestDTO.getShippingAddress().getCountryCode());

                responseDTO.setShippingAddress(addrDTO);
            }
        }

        // Step 8: Return response
        return responseDTO;
    }
}
