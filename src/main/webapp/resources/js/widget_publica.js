var HelloWorld = SuperWidget.extend({
    message: null,

    init: function () {
        //code
    },

    bindings: {
        local: {
            'iniciar-processo': ['click_iniciarProcessoSeletivo'],
            'salvarParametros': ['click_salvar']
        }
    },

    iniciarProcessoSeletivo: function () {
        var nome = $("#nome_"+this.instanceId).val();
        var email = $("#email_"+this.instanceId).val();
        var telefone = $("#telefone_"+this.instanceId).val();
        var vaga = $("#vaga_"+this.instanceId).val();

        var matricula = $("#viewMatricula_"+this.instanceId).val();
        var atividade = $("#viewAtividade_"+this.instanceId).val();

        var url = WCMAPI.getServerURL() + '/widget_publica/api/rest/service/iniciarProcessoSeletivo';
        var data = {
        		'nome': nome,
        		'email': email,
        		'telefone': telefone,
        		'vaga': vaga,
        		'matricula': matricula,
        		'atividade': atividade
        };

        WCMAPI.Read({
            type: "POST",
            url: url,
            async: true,
            data: JSON.stringify(data),
            success: function funcao(data) {
                console.log(data);
                var msg = "O processo seletivo foi iniciado foi iniciado com sucesso, a seguinte solicitação foi criada: " + data.processInstanceId
                FLUIGC.toast({
                	title: "Parabéns!",
                	message: msg,
                	type:"success"
                });
            },
            
            error: function (requestObject, error, errorThrown) {
                console.log(requestObject);
                console.log(error);
                console.log(errorThrown);
                
                FLUIGC.toast({
                	title: "Ops!",
                	message: "Aconteceu um erro inesperado! Por favor, contate o administrador.",
                	type:"danger"
                });
            }
        });
    },
    
    salvar: function(){
	
		var matriculaUser = $("#editMatricula_"+this.instanceId).val();
		var ativDest = $("#editAtividade_"+this.instanceId).val();
		
		var preferences = {
			matricula: matriculaUser,
			atividade: ativDest
		};
		  
		WCMSpaceAPI.PageService.UPDATEPREFERENCES({
		    async: true,
		    success: function (data) {
	    	    FLUIGC.toast({
    		        title: '',
    		        message: 'Preferencias salvas com sucesso.',
    		        type: 'success'
    		    });
		    },
		    fail: function (xhr, message, errorData) {
		    	FLUIGC.toast({
    		        title: '',
    		        message: 'Erro ao salvar preferencias.',
    		        type: 'error'
    		    });
		    }
		}, this.instanceId, preferences);
	}
});