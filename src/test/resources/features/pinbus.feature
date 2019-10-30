@viaje
Feature: Pagina de viajes pinbus
  As
  usuario no registrado
  I want
  realizar la compra de un viaje

  @reservarBus
  Scenario: Hacer la reserva de bus para la silla y fecha especifica
  Given que me encuentro en la pagina inicial
  And seleccionar un bus y fecha para el viaje "01"
  When lleno las informacion de los pasajeros
  Then valido la sumatoria del viaje