Process("_34AFSOdqu398ur923f90w1" "BuyProduct") {
	Start("_WweLMMM4Ee6hX_TYQcgODA" start "_X8OzsMM4Ee6hX_TYQcgODA._cMlOkMM4Ee6hX_TYQcgODA")
	End("_R7T9oMM5Ee6hX_TYQcgODA" end)
	Actor("_X8OzsMM4Ee6hX_TYQcgODA" StoreManager) {
		UseCase("_cMlOkMM4Ee6hX_TYQcgODA" openStore "_ZNHz0MM4Ee6hX_TYQcgODA._dn1roMM4Ee6hX_TYQcgODA")
		UseCase("_iTJkMMM4Ee6hX_TYQcgODA" showStockReports "_oP3aQMM4Ee6hX_TYQcgODA")
		Branch("_oP3aQMM4Ee6hX_TYQcgODA" "" "_ZNHz0MM4Ee6hX_TYQcgODA._g3wkQMM4Ee6hX_TYQcgODA" "_s3lMQMM4Ee6hX_TYQcgODA" "_ZNHz0MM4Ee6hX_TYQcgODA._vKDlMMM4Ee6hX_TYQcgODA")
		UseCase("_s3lMQMM4Ee6hX_TYQcgODA" listSuppliers "_zesDIMM4Ee6hX_TYQcgODA")
		UseCase("_zesDIMM4Ee6hX_TYQcgODA" orderProducts "_ZNHz0MM4Ee6hX_TYQcgODA._2mfhkMM4Ee6hX_TYQcgODA")
		UseCase("_8X2cMMM4Ee6hX_TYQcgODA" receiveOrderedProduct "_FxRCoMM5Ee6hX_TYQcgODA")
		UseCase("_FxRCoMM5Ee6hX_TYQcgODA" showStockReports "_ZNHz0MM4Ee6hX_TYQcgODA._vKDlMMM4Ee6hX_TYQcgODA")
		UseCase("_NTSpoMM5Ee6hX_TYQcgODA" closeStore "_R7T9oMM5Ee6hX_TYQcgODA")
	}
	Actor("_ZNHz0MM4Ee6hX_TYQcgODA" Cashier) {
		UseCase("_dn1roMM4Ee6hX_TYQcgODA" openCashDesk "_g3wkQMM4Ee6hX_TYQcgODA")
		UseCase("_g3wkQMM4Ee6hX_TYQcgODA" processSale "_X8OzsMM4Ee6hX_TYQcgODA._iTJkMMM4Ee6hX_TYQcgODA")
		UseCase("_vKDlMMM4Ee6hX_TYQcgODA" closeCashDesk "_X8OzsMM4Ee6hX_TYQcgODA._NTSpoMM5Ee6hX_TYQcgODA")
		Branch("_2mfhkMM4Ee6hX_TYQcgODA" "" "_vKDlMMM4Ee6hX_TYQcgODA" "_X8OzsMM4Ee6hX_TYQcgODA._8X2cMMM4Ee6hX_TYQcgODA")
	}
}