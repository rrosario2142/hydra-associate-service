# hydra-associate-service

Fields (columns) of associate table (CALIBER_ASSOCIATE):

Markup: * Associate
			* Integer associateId (ASSOCIATE_ID)
			* String associateFirstName (ASSOCIATE_FIRST_NAME)
			* String associateLastName (ASSOCIATE_LAST_NAME)
			* Integer marketingStatusId (MARKETING_STATUS_ID)
			* Integer clientId (CLIENT_ID)
			* Integer endClientId (END_CLIENT_ID)
			* Integer batchId (BATCH_ID)
			
AssociateController methods and endpoints:

Markup: * findOneByAssociateId(@PathVariable Integer id); GET; endpoint: /one/associate/{id}
		* findAll(); GET; endpoint: /all/associate
		* findAllByMarketingStatusId(@PathVariable Integer id); GET; endpoint: /all/associate/marketingStatus/{id}
		* findAllByClientId(@PathVariable Integer id); GET; endpoint: /all/associate/client/{id}
		* findAllByEndClientId(@PathVariable Integer id); GET; endpoint: /all/associate/endClient/{id}
		* findAllByBatchId(@PathVariable Integer id); GET; endpoint: /all/associate/batch/{id}
		* addAssociate(@Valid @RequestBody Associate associate); POST; endpoint: /associate/add
		* updateAssociate(@Valid @RequestBody Associate associate); PUT; endpoint: /associate/update
		* deleteAssociate(@PathVariable Integer id); DELETE; endpoint: /associate/delete/{id}