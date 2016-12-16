
<!-- Modal -->
	<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
		   <div class="modal-content">
			 <div class="modal-header">
			 	<button type='button' class='close' data-dismiss='modal' aria-label='Close'>
			 		<span aria-hidden='true'>&times;</span>
		 		</button>
				<h4 class='modal-title' id='myModalLabel'>
					{{vm.modalHeader}}
				</h4>
			 </div>
			 <div class="modal-body">
				<div class='alert {{vm.alertModal}}'>
					<ul>
						{{vm.modalBody}}
					</ul>
				</div>
			 </div>
			 <div class="modal-footer">
			 	<button type='button' class='btn {{vm.btnModal}}' ng-click="vm.voltarLogin()" data-dismiss='modal'>
			 		{{vm.modalFooter}}
			 	</button>
			 </div>
		   </div>
		</div>
	</div>	
<!-- Fim Modal -->