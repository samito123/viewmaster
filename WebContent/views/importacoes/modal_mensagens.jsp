
<!-- Modal -->
	<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
		   <div class="modal-content">
			 <div class="modal-header">
			 	<button type='button' class='close' data-dismiss='modal' aria-label='Close'>
			 		<span aria-hidden='true'>&times;</span>
		 		</button>
				<h4 class='modal-title' id='myModalLabel'>
					{{lg.modalHeader}}
				</h4>
			 </div>
			 <div class="modal-body">
				<div class='alert {{lg.alertModal}}'>
					<ul>
						{{lg.modalBody}}
					</ul>
				</div>
			 </div>
			 <div class="modal-footer">
			 	<button type='button' class='btn {{lg.btnModal}}' ng-click="lg.voltarLogin()" data-dismiss='modal'>
			 		{{lg.modalFooter}}
			 	</button>
			 </div>
		   </div>
		</div>
	</div>	
<!-- Fim Modal -->